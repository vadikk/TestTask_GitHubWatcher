package com.example.vadym.github_watcher.recycler.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vadym.github_watcher.R;
import com.example.vadym.github_watcher.model.GitHubInfo;
import com.example.vadym.github_watcher.model.GitHubOwner;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vadym on 16.03.2018.
 */

public class GitHubViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageAvatar)
    ImageView avatar;
    @BindView(R.id.nameRepository)
    TextView name;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.forkCount)
    TextView forkCount;

    public GitHubViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void setText(GitHubInfo info) {

        GitHubOwner owner = info.getOwner();
        String avatarUrl = owner.getAvatar();

        Picasso.with(this.itemView.getContext())
                .load(avatarUrl)
                .placeholder(null)
                .into(avatar);

        name.setText(info.getName());
        description.setText(info.getDescription());
        forkCount.setText(info.getForks_count());
    }
}
