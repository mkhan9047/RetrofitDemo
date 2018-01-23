package com.example.mujahid.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Mujahid on 1/23/2018.
 */

public interface ApiInterface {
    @POST("jsons.php")
    Call<List<Contact>> getConatct();
}
