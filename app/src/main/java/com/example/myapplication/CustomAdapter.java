package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    ArrayList<Mucsic> mMucsics;

    public CustomAdapter(ArrayList<Mucsic> mMucsics) {
        this.mMucsics = mMucsics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return mMucsics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tenbh,tencs,thoiluong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenbh = itemView.findViewById(R.id.tv_tenbh);
            tencs = itemView.findViewById(R.id.tv_tencs);
            thoiluong = itemView.findViewById(R.id.tv_thoiluong);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mucsic music1 = mMucsics.get(position);
        holder.tenbh.setText(music1.getTenbh());
        holder.tencs.setText(music1.getTencs());
        holder.thoiluong.setText(music1.getThoiluong());

    }
}
