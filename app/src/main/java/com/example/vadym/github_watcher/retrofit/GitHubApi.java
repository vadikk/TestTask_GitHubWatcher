package com.example.vadym.github_watcher.retrofit;

import com.example.vadym.github_watcher.model.GitHubOwner;
import com.example.vadym.github_watcher.model.GitHubResponce;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Vadym on 16.03.2018.
 */

public interface GitHubApi {

    @GET("search/repositories?per_page=10")
    Flowable<GitHubResponce> getGitHubResponce(@Query("q") String name, @Query("page") int page);

    @GET("repos/{full_name}/subscribers?per_page=10")
    Flowable<List<GitHubOwner>> getListSubscriber(@Path(value = "full_name", encoded = true) String nameRepository, @Query("page") int page);
}
