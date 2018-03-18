package com.example.vadym.github_watcher.recycler.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vadym.github_watcher.R;
import com.example.vadym.github_watcher.model.GitHubOwner;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vadym on 18.03.2018.
 */

public class GitHubDetailViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageDetailAvatar)
    ImageView imageView;
    @BindView(R.id.nameDetailUser)
    TextView nameUser;
    @BindView(R.id.htmlUrl)
    TextView htmlUrl;

    public GitHubDetailViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void setText(GitHubOwner owner) {

        Picasso.with(this.itemView.getContext())
                .load(owner.getAvatar())
                .placeholder(null)
                .into(imageView);

        nameUser.setText(owner.getLogin());
        htmlUrl.setText(owner.getHtmlUrl());

    }
}
