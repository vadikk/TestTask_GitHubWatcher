package com.example.vadym.github_watcher.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym on 16.03.2018.
 */

public class GitHubResponce {

    private int total_count;
    @SerializedName("incomplete_results")
    private String results;
    private List<GitHubInfo> items = new ArrayList<>();

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public List<GitHubInfo> getItems() {
        return items;
    }

    public void setItems(List<GitHubInfo> items) {
        this.items = items;
    }
}
