package com.example.vadym.github_watcher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vadym.github_watcher.R;
import com.example.vadym.github_watcher.model.GitHubInfo;
import com.example.vadym.github_watcher.recycler.main.GitHubAdapter;
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

public class MainActivity extends AppCompatActivity implements OnGitHubUserListener {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.search)
    SearchView searchView;
    @BindView(R.id.progressBar)
    ProgressBar bar;
    @BindView(R.id.errorCardView)
    CardView cardView;
    @BindView(R.id.errorText)
    TextView errorText;

    private GitHubAdapter adapter;
    private String searchText;
    private CompositeDisposable compositeDisposable;
    private int page = 1;
    private boolean isLoading = false;
    private int allTotalCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        compositeDisposable = new CompositeDisposable();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        adapter = new GitHubAdapter();
        adapter.setOnUserListener(this);
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.clear();
                searchText = query;
                page = 1;
                isLoading = true;
                loadData(query, page);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (isLoading) return;

                int lastVisibleItemCount = manager.findLastVisibleItemPosition();
                int addLoadedItemCount = adapter.getItemCount();
                int loadShouldStartPosition = (int) (addLoadedItemCount * 0.8);

                if (loadShouldStartPosition <= lastVisibleItemCount && addLoadedItemCount < allTotalCount) {
                    page++;
                    isLoading = true;
                }

                if (isLoading) {
                    loadData(searchText, page);
                }

            }
        });
    }

    private void loadData(String query, int page) {

        bar.setVisibility(View.VISIBLE);

        Flowable flowable = GitHubRetrofit.getRetrofit().getGitHubResponce(query, page)
                .doOnNext(gitHubResponce -> allTotalCount = gitHubResponce.getTotal_count())
                .flatMap(gitHubResponce -> Flowable.just(gitHubResponce.getItems()))
                .filter(list -> !list.isEmpty())
                .delay(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .flatMapCompletable(this::addToAdapter).toFlowable()
                .onErrorReturn(throwable -> {
                    setProgressBarGone();
                    showErrorView(throwable.getMessage());
                    return true;
                });

        Disposable disposables = flowable.subscribe();

        compositeDisposable.add(disposables);

    }

    private Completable addToAdapter(List<GitHubInfo> list) {
        return Completable.fromAction(() -> {
            adapter.addAllItemToList(list);
            isLoading = false;
            setProgressBarGone();
        });
    }

    private void setProgressBarGone() {
        Completable.timer(1, TimeUnit.SECONDS,
                AndroidSchedulers.mainThread()).subscribe(() -> bar.setVisibility(View.GONE));
    }

    @Override
    protected void onDestroy() {

        if (compositeDisposable != null)
            compositeDisposable.clear();

        super.onDestroy();
    }

    @Override
    public void onUserListener(int position) {

        GitHubInfo info = adapter.getGitHubInfo(position);
        String fullName = info.getFull_name();
        int watchersCount = info.getWatchers();

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.FULL_NAME, fullName);
        intent.putExtra(DetailActivity.WATCHERS, watchersCount);
        startActivity(intent);
    }

    private void showErrorView(String text) {
        cardView.setVisibility(View.VISIBLE);
        errorText.setText(text);
    }
}
