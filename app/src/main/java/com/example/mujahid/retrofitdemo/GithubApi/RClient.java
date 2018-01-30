package com.example.mujahid.retrofitdemo.GithubApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mujahid on 1/30/2018.
 */

public class RClient {

    private static final String baseUrl = "https://api.github.com/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){

        if(retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
