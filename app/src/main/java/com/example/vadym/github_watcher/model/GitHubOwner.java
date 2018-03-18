package com.example.vadym.github_watcher.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vadym on 16.03.2018.
 */

public class GitHubOwner {

    private String login;
    private String id;
    @SerializedName("avatar_url")
    private String avatar;
    private String url;
    @SerializedName("gravatar_id")
    private String gravatarId;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("followers_url")
    private String followersUrl;
    @SerializedName("following_url")
    private String followingUrl;
    @SerializedName("gists_url")
    private String gistsUrl;
    @SerializedName("starred_url")
    private String starredUrl;
    @SerializedName("subscriptions_url")
    private String subscriptionUrl;
    @SerializedName("organizations_url")
    private String organizationUrl;
    @SerializedName("repos_url")
    private String reposUrl;
    @SerializedName("events_url")
    private String eventsUrl;
    @SerializedName("received_events_url")
    private String receivedUrl;
    private String type;
    @SerializedName("site_admin")
    private String site;

    public GitHubOwner() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    public String getOrganizationUrl() {
        return organizationUrl;
    }

    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedUrl() {
        return receivedUrl;
    }

    public void setReceivedUrl(String receivedUrl) {
        this.receivedUrl = receivedUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
