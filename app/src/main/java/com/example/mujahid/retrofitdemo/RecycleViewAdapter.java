package com.example.mujahid.retrofitdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mujahid on 1/23/2018.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Contact> data = new ArrayList<>();

    public RecycleViewAdapter(List<Contact> d){
        data  = d;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customrecycle,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       holder.name.setText(data.get(position).getName());
       holder.father_name.setText(data.get(position).getFather_name());
       holder.email.setText(data.get(position).getEmail());
       holder.phone.setText(data.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, father_name, email, phone;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.show_name);
            father_name = itemView.findViewById(R.id.show_fatherName);
            email = itemView.findViewById(R.id.show_email);
            phone = itemView.findViewById(R.id.show_phone);
        }

    }

}
