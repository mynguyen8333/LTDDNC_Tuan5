package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<Mucsic> mMucsics;
    private OnclickListener1 onclick;

    public CustomAdapter(ArrayList<Mucsic> mMucsics, OnclickListener1 onclick) {
        this.mMucsics = mMucsics;
        this.onclick = onclick;
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
        Mucsic musicClick;
        TextView tenbh,tencs,thoiluong;
        ImageView img_anh;
        ImageButton btnplay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenbh = itemView.findViewById(R.id.tv_tenbh);
            tencs = itemView.findViewById(R.id.tv_tencs);
            thoiluong = itemView.findViewById(R.id.tv_thoiluong);
            btnplay = itemView.findViewById(R.id.btn_play);
            img_anh = itemView.findViewById(R.id.img_casi);
            itemView.setOnClickListener(view->{
                onclick.clickitem(musicClick,img_anh);
            });
            btnplay.setOnClickListener(view->{
                onclick.clickbutton(musicClick);
            });

        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mucsic music1 = mMucsics.get(position);
        holder.img_anh.setImageResource(music1.getAnh());
        holder.musicClick = music1;
        holder.tenbh.setText(music1.getTenbh());
        holder.tencs.setText(music1.getTencs());
        holder.thoiluong.setText(music1.getThoiluong());

    }
}
