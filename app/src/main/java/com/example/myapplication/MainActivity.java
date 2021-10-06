package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnclickListener1{
    RecyclerView rsv_music;
    CustomAdapter adt;
    ArrayList<Mucsic> mMusics;
    TextView tv_tenbh2,tv_tencs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMusics = new ArrayList<>();
        rsv_music = findViewById(R.id.rsv_music);
        tv_tenbh2 = findViewById(R.id.tv_tenbh2);
        tv_tencs2 = findViewById(R.id.tv_tencs2);

        mMusics.add(new Mucsic("Dusk Till Dawn","ZAYN ft. Sia","5:25",R.drawable.sia));
        mMusics.add(new Mucsic("Hello","Adele ","4:37",R.drawable.hello));
        mMusics.add(new Mucsic("See You Again","Wiz Khalifa ft. Charlie Puth","3:57",R.drawable.charlie));
        mMusics.add(new Mucsic("Shape of You","Ed Sheeran","4:23",R.drawable.ed));
        mMusics.add(new Mucsic("Waiting For Love","Avicii ","3:50",R.drawable.ativi));


        adt = new CustomAdapter(mMusics,this);
        rsv_music.setHasFixedSize(true);
        rsv_music.setAdapter(adt);
        rsv_music.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void clickitem(Mucsic m) {

    }

    @Override
    public void clickbutton(Mucsic m) {
        tv_tencs2.setText(m.getTencs());
        tv_tenbh2.setText(m.getTenbh());
    }
}