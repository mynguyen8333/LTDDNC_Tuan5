package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
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

        mMusics.add(new Mucsic("Dusk Till Dawn","ZAYN ft. Sia","5:25",R.drawable.sia,R.raw.dusktilldawn));
        mMusics.add(new Mucsic("Hello","Adele ","4:37",R.drawable.hello,R.raw.hellodd));
        mMusics.add(new Mucsic("See You Again","Wiz Khalifa ft. Charlie Puth","3:57",R.drawable.charlie,R.raw.seeyouagain));
        mMusics.add(new Mucsic("Shape of You","Ed Sheeran","4:23",R.drawable.ed,R.raw.shapeofyou));
        mMusics.add(new Mucsic("Waiting For Love","Avicii ","3:50",R.drawable.ativi,R.raw.watingforlove));


        adt = new CustomAdapter(mMusics,this);
        rsv_music.setHasFixedSize(true);
        rsv_music.setAdapter(adt);
        rsv_music.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }


    @Override
    public void clickitem(Mucsic m, ImageView img) {
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("music",m);
        ActivityOptionsCompat options =  ActivityOptionsCompat.makeSceneTransitionAnimation(
                MainActivity.this, img,
                ViewCompat.getTransitionName(img));
        startActivity(intent,options.toBundle());

    }

    @Override
    public void clickbutton(Mucsic m) {
        tv_tencs2.setText(m.getTencs());
        tv_tenbh2.setText(m.getTenbh());
    }
}