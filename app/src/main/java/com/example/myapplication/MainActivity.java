package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rsv_music;
    CustomAdapter adt;
    ArrayList<Mucsic> mMusics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMusics = new ArrayList<>();
        rsv_music = findViewById(R.id.rsv_music);

        mMusics.add(new Mucsic("Dusk Till Dawn","ZAYN ft. Sia","5:25"));
        mMusics.add(new Mucsic("Hello","Adele ","4:37"));
        mMusics.add(new Mucsic("See You Again","Wiz Khalifa ft. Charlie Puth","3:57"));
        mMusics.add(new Mucsic("Shape of You","Ed Sheeran","4:23"));
        mMusics.add(new Mucsic("Waiting For Love","Avicii ","3:50"));


        adt = new CustomAdapter(mMusics);
        rsv_music.setHasFixedSize(true);
        rsv_music.setAdapter(adt);
        rsv_music.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}