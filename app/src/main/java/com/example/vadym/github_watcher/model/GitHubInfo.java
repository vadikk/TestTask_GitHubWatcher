package com.example.vadym.github_watcher.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vadym on 16.03.2018.
 */

public class GitHubInfo {

    private String id;
    private String name;
    private String full_name;
    private GitHubOwner owner;
    private String description;
    private String forks_count;
    @SerializedName("subscribers_url")
    private String subscribersUrl;
    private int watchers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public GitHubOwner getOwner() {
        return owner;
    }

    public void setOwner(GitHubOwner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getForks_count() {
        return forks_count;
    }

    public void setForks_count(String forks_count) {
        this.forks_count = forks_count;
    }

    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }
}
