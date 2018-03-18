package com.example.vadym.github_watcher.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vadym.github_watcher.R;
import com.example.vadym.github_watcher.model.GitHubOwner;
import com.example.vadym.github_watcher.recycler.detail.GitHubDetailAdapter;
import com.example.vadym.github_watcher.retrofit.GitHubRetrofit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DetailActivity extends AppCompatActivity {

    public static String FULL_NAME = "full_name";
    public static String WATCHERS = "watchers";

    @BindView(R.id.recyclerDetail)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.errorCardView)
    CardView cardView;
    @BindView(R.id.errorText)
    TextView errorText;

    private GitHubDetailAdapter adapter;
    private String fullName;
    private int page = 1;
    private CompositeDisposable compositeDisposable;
    private boolean isLoading = false;
    private int subscriberCount = 0;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar == null)
            return;

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        compositeDisposable = new CompositeDisposable();

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            fullName = bundle.getString(FULL_NAME);
            subscriberCount = bundle.getInt(WATCHERS);
        }
        actionBar.setTitle(fullName);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        adapter = new GitHubDetailAdapter();
        recyclerView.setAdapter(adapter);

        loadDetailListSubscriber(fullName, page);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (isLoading) return;

                int lastVisibleItemCount = manager.findLastVisibleItemPosition();
                int addLoadedItemCount = adapter.getItemCount();
                int loadShouldStartPosition = (int) (addLoadedItemCount * 0.8);

                if (loadShouldStartPosition <= lastVisibleItemCount && addLoadedItemCount < subscriberCount) {
                    page++;
                    isLoading = true;
                }

                if (isLoading) {
                    loadDetailListSubscriber(fullName, page);
                }
                Log.d("TAG", "last " + lastVisibleItemCount + " load " + loadShouldStartPosition + " subs " + subscriberCount);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadDetailListSubscriber(String path, int page) {

        progressBar.setVisibility(View.VISIBLE);

        Flowable flowable = GitHubRetrofit.getRetrofit().getListSubscriber(path, page)
                .filter(list -> !list.isEmpty())
                .delay(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .flatMapCompletable(this::addDataToAdapter).toFlowable()
                .onErrorReturn(throwable -> {
                    setProgressBarGone();
                    showErrorView(throwable.getMessage());
                    return true;
                });

        Disposable disposable = flowable.subscribe();
        compositeDisposable.add(disposable);

    }

    @Override
    protected void onDestroy() {

        if (compositeDisposable != null)
            compositeDisposable.clear();

        super.onDestroy();
    }

    private Completable addDataToAdapter(List<GitHubOwner> list) {
        return Completable.fromAction(() -> {
            adapter.addAllItemToList(list);
            isLoading = false;
            setProgressBarGone();
        });
    }

    private void setProgressBarGone() {
        Completable.timer(1, TimeUnit.SECONDS,
                AndroidSchedulers.mainThread()).subscribe(() -> progressBar.setVisibility(View.GONE));
    }

    private void showErrorView(String text) {
        cardView.setVisibility(View.VISIBLE);
        errorText.setText(text);
    }

}
