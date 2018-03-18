package com.example.vadym.github_watcher.recycler.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vadym.github_watcher.R;
import com.example.vadym.github_watcher.model.GitHubOwner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym on 18.03.2018.
 */

public class GitHubDetailAdapter extends RecyclerView.Adapter<GitHubDetailViewHolder> {

    private List<GitHubOwner> list = new ArrayList<>();

    public GitHubDetailAdapter() {
    }

    public void addAllItemToList(List<GitHubOwner> list) {
        int startPos = getItemCount();
        notifyItemRangeInserted(startPos, list.size());
        this.list.addAll(list);
    }

    @Override
    public GitHubDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_row, parent, false);
        return new GitHubDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GitHubDetailViewHolder holder, int position) {
        GitHubOwner owner = list.get(holder.getAdapterPosition());

        if (owner != null) {
            holder.setText(owner);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
