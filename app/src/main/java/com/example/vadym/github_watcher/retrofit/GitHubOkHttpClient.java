package com.example.vadym.github_watcher.retrofit;

import com.example.vadym.github_watcher.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Vadym on 17.03.2018.
 */

public class GitHubOkHttpClient {

    private static final int TIMEOUT_CONNECTION = 10;

    public static OkHttpClient getOkHttpClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        httpClient.connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS);
        httpClient.addInterceptor(loggingInterceptor);

        return httpClient.build();
    }
}
