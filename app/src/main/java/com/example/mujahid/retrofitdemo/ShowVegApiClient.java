package com.example.mujahid.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mujahid on 1/25/2018.
 */

public class ShowVegApiClient {
    private static final String BaseURL = "http://10.0.2.2/";
 public static    Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit =  new Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
