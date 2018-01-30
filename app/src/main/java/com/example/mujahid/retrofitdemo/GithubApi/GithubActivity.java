package com.example.mujahid.retrofitdemo.GithubApi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mujahid.retrofitdemo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubActivity extends AppCompatActivity {
 ListView listView;
 RecyclerView recyclerView;
 RecyclerView.LayoutManager layoutManager;
 GithubRecycler adapter;
 ArrayAdapter<String> arrayAdapter;
 List<GithubRepo> repos;
 GithubInterface githubInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);
        recyclerView = findViewById(R.id.listview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        githubInterface = RClient.getRetrofit().create(GithubInterface.class);
     Call<List<GithubRepo>> list =  githubInterface.getRepos("mkhan9047");
     list.enqueue(new Callback<List<GithubRepo>>() {
         @Override
         public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
             repos = response.body();
             adapter = new GithubRecycler(repos,getApplicationContext());
             recyclerView.setAdapter(adapter);

         }

         @Override
         public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
             Log.d("error:", t.getMessage());
         }
     });
    }
}
