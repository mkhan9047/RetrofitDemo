package com.example.mujahid.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Vagitable extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ShowVegApiInterface apiInterface;
    showCalorieAdapter adapter;
    List<Calories> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vagitable);
        recyclerView = findViewById(R.id.recycleVeg);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        String data = getIntent().getStringExtra("get");

        apiInterface = ShowVegApiClient.getRetrofit().create(ShowVegApiInterface.class);
        final Call<List<Calories>> listCall = apiInterface.getCaloires(data);
        listCall.enqueue(new Callback<List<Calories>>() {
            @Override
            public void onResponse(Call<List<Calories>> call, Response<List<Calories>> response) {
                list = response.body();
                adapter = new showCalorieAdapter(list,Vagitable.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Calories>> call, Throwable t) {
                Log.d("error",t.getMessage());
            }
        });
    }


}
