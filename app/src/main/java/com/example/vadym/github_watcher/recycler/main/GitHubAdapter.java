package com.example.vadym.github_watcher.recycler.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vadym.github_watcher.R;
import com.example.vadym.github_watcher.activities.OnGitHubUserListener;
import com.example.vadym.github_watcher.model.GitHubInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym on 16.03.2018.
 */

public class GitHubAdapter extends RecyclerView.Adapter<GitHubViewHolder> {

    private List<GitHubInfo> infoList = new ArrayList<>();
    private OnGitHubUserListener listener;

    public GitHubAdapter() {
    }

    public void setOnUserListener(OnGitHubUserListener listener) {
        this.listener = listener;
    }

    public void addAllItemToList(List<GitHubInfo> list) {
        int startPos = getItemCount();
        notifyItemRangeInserted(startPos, list.size());
        infoList.addAll(list);
    }

    public GitHubInfo getGitHubInfo(int position) {
        if (position < 0 || position > getItemCount())
            return null;

        return infoList.get(position);
    }

    public void clear() {
        notifyItemRangeRemoved(0, getItemCount());
        infoList.clear();
    }

    @Override
    public GitHubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new GitHubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GitHubViewHolder holder, int position) {
        GitHubInfo info = infoList.get(holder.getAdapterPosition());

        if (info != null) {
            holder.setText(info);
            holder.itemView.setOnClickListener(view -> onUserClick(holder.getAdapterPosition()));
        }
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    private void onUserClick(int position) {
        if (listener != null) {
            listener.onUserListener(position);
        }
    }
}
