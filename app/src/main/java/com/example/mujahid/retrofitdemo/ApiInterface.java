package com.example.mujahid.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Mujahid on 1/23/2018.
 */

public interface ApiInterface {
    @POST("jsons.php")
    Call<List<Contact>> getConatct(@Query("name") String name);
}
