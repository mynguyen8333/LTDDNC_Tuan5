package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    ImageView img_casi;
    TextView tv_tencs,tv_thoiluong,tv_tenbh;
    Mucsic mucsic;
    ImageButton btnplay;
    String tenbh;
    //chay nhac
    MediaPlayer mp;
    int count = 1;
    int totalTime;
    TextView txtbd,txtkt;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img_casi = findViewById(R.id.img_casi2);
        tv_tenbh = findViewById(R.id.tv_tenbh3);
        tv_tencs = findViewById(R.id.tv_tencs3);
        tv_thoiluong = findViewById(R.id.tv_ketthuc);
        btnplay = findViewById(R.id.btn_play2);
        //phat nhac
        txtbd = findViewById(R.id.tv_batdau);
        txtkt = findViewById(R.id.tv_ketthuc);
        progressBar = findViewById(R.id.progressBar2);
        //totalTime =MediaPlayer.create(getBaseContext(),R.raw.shapeofyou).getDuration();


        Intent intent = getIntent();
        if(intent!=null){
            mucsic = (Mucsic) intent.getSerializableExtra("music");
            img_casi.setImageResource(mucsic.getAnh());
            tv_tenbh.setText(mucsic.getTenbh());
            Toast.makeText(MainActivity2.this,tv_tenbh.getText(),Toast.LENGTH_LONG);
            tv_tencs.setText(mucsic.getTencs());
            tv_thoiluong.setText(mucsic.getThoiluong());

            tenbh = mucsic.getTenbh();

            if(tenbh.equalsIgnoreCase("Dusk Till Dawn")){
                totalTime =MediaPlayer.create(getBaseContext(),R.raw.dusktilldawn).getDuration();
            }if(tenbh.equalsIgnoreCase("Hello")){
                totalTime =MediaPlayer.create(getBaseContext(),R.raw.hellodd).getDuration();
            }if(tenbh.equalsIgnoreCase("See You Again")){
                totalTime =MediaPlayer.create(getBaseContext(),R.raw.seeyouagain).getDuration();
            }if(tenbh.equalsIgnoreCase("Shape of You")){
                totalTime =MediaPlayer.create(getBaseContext(),R.raw.shapeofyou).getDuration();
            }if(tenbh.equalsIgnoreCase("Waiting For Love")){
                totalTime =MediaPlayer.create(getBaseContext(),R.raw.watingforlove).getDuration();
            }
        }

        btnplay.setOnClickListener(view->{
            if(count++ %2 ==0) mp.stop();
            else{
                //mp = MediaPlayer.create(getBaseContext(), R.raw.shapeofyou);
                if(tenbh.equalsIgnoreCase("Dusk Till Dawn")){
                    mp = MediaPlayer.create(getBaseContext(), R.raw.dusktilldawn);
                }if(tenbh.equalsIgnoreCase("Hello")){
                    mp = MediaPlayer.create(getBaseContext(), R.raw.hellodd);
                }if(tenbh.equalsIgnoreCase("See You Again")){
                    mp = MediaPlayer.create(getBaseContext(), R.raw.seeyouagain);
                }if(tenbh.equalsIgnoreCase("Shape of You")){
                    mp = MediaPlayer.create(getBaseContext(), R.raw.shapeofyou);
                }if(tenbh.equalsIgnoreCase("Waiting For Love")){
                    mp = MediaPlayer.create(getBaseContext(), R.raw.watingforlove);
                }
                mp.setLooping(false);
                mp.start();
                if(mp.isPlaying()) {
                    txtbd.post(mUpdateTime);
                    progressBar.post(mUpdateProgress);
                }

            }
        });
    }

    private Runnable mUpdateProgress = new Runnable() {
        public void run() {
            int currentDuration;
            if (mp.isPlaying()) {
                currentDuration = mp.getCurrentPosition();
                double time = currentDuration * 1.0 / totalTime * 100;
                progressBar.setProgress((int) time);
                progressBar.postDelayed(this, 1000);
            }else {
                progressBar.removeCallbacks(this);
            }
        }
    };

    private Runnable mUpdateTime = new Runnable() {
        public void run() {
            int currentDuration;
            if (mp.isPlaying()) {
                currentDuration = mp.getCurrentPosition();
                updatePlayer(currentDuration);
                txtbd.postDelayed(this, 1000);
            }else {
                txtbd.removeCallbacks(this);
            }
        }
    };

    private void updatePlayer(int currentDuration){
        txtbd.setText("" + milliSecondsToTimer((long) currentDuration));
    }

    public  String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // Add hours if there
        if (hours > 0) finalTimerString += (hours > 9 ? hours : "0" + hours) + ":";
        finalTimerString += (minutes > 9 ? minutes : "0" + minutes) + ":";
        finalTimerString += (seconds > 9 ? seconds : "0" + seconds);

        // return timer string
        return finalTimerString;
    }
}