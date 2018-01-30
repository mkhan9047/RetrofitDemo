package com.example.mujahid.retrofitdemo.GithubApi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mujahid.retrofitdemo.Contact;
import com.example.mujahid.retrofitdemo.R;
import com.example.mujahid.retrofitdemo.RecycleViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mujahid on 1/30/2018.
 */

public class GithubRecycler extends RecyclerView.Adapter<GithubRecycler.MyViewHolder> {

    Context context;
    List<GithubRepo> data = new ArrayList<>();

    public GithubRecycler(List<GithubRepo> d, Context context){
        data  = d;
        this.context = context;
    }
    @Override
    public GithubRecycler.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.github_recycler,parent,false);

        return new GithubRecycler.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GithubRecycler.MyViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        Picasso.with(context).load(data.get(position).getOwner().getImage_url()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.avater);

        }

    }

}
