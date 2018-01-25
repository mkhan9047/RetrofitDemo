package com.example.mujahid.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mujahid on 1/25/2018.
 */

public interface ShowVegApiInterface {
    @GET("getCalorieData.php")
    Call<List<Calories>> getCaloires(@Query("item_type") String item);

}
