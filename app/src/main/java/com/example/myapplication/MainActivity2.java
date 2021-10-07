package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView img_casi;
    TextView tv_tencs,tv_thoiluong,tv_tenbh;
    Mucsic mucsic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img_casi = findViewById(R.id.img_casi2);
        tv_tenbh = findViewById(R.id.tv_tenbh3);
        tv_tencs = findViewById(R.id.tv_tencs3);
        tv_thoiluong = findViewById(R.id.tv_ketthuc);

        Intent intent = getIntent();
        if(intent!=null){
            mucsic = (Mucsic) intent.getSerializableExtra("music");
            img_casi.setImageResource(mucsic.getAnh());
            tv_tenbh.setText(mucsic.getTenbh());
            tv_tencs.setText(mucsic.getTencs());
            tv_thoiluong.setText(mucsic.getThoiluong());
        }
    }
}