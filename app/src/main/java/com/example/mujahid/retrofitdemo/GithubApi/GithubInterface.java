package com.example.mujahid.retrofitdemo.GithubApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Mujahid on 1/30/2018.
 */

public interface GithubInterface {

   @GET("users/{user}/repos")
    Call<List<GithubRepo>> getRepos(@Path("user") String user);
}
