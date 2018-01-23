package com.example.mujahid.retrofitdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.LayoutManager layoutManager;
RecycleViewAdapter adapter;
List<Contact> list;
ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
 recyclerView = findViewById(R.id.recycle);
 layoutManager = new LinearLayoutManager(this);
 recyclerView.setLayoutManager(layoutManager);
 recyclerView.setHasFixedSize(true);
 apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
 final Call<List<Contact>> contact = apiInterface.getConatct();
 contact.enqueue(new Callback<List<Contact>>() {
    @Override
    public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
        list = response.body();
        adapter = new RecycleViewAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<Contact>> call, Throwable t) {
        Log.d("error",t.getMessage());
    }
 });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
