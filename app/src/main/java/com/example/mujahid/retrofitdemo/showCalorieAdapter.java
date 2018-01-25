package com.example.mujahid.retrofitdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mujahid on 1/25/2018.
 */

public class showCalorieAdapter extends RecyclerView.Adapter<showCalorieAdapter.MyCaloriViewHolder> {

    List<Calories> data = new ArrayList<>();
    Context context;
    public showCalorieAdapter(List<Calories> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public MyCaloriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_vegi_and_furits_custom,parent,false);

        return new MyCaloriViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(MyCaloriViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        Picasso.with(context)
                .load(data.get(position).getImg_URL())
                .into(holder.imageView);
        Log.d("url",data.get(position).getImg_URL());
        holder.price.setText(String.format("$%d",data.get(position).getPrice()));
        holder.calorie.setText(String.format("C: %d",data.get(position).getCalorie()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyCaloriViewHolder extends RecyclerView.ViewHolder{
        TextView name, price, calorie;
        CircleImageView imageView;
        public MyCaloriViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.main_Image);
            calorie = itemView.findViewById(R.id.calorie);
        }
    }
}
