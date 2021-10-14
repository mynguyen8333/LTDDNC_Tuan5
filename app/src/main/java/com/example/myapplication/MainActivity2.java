package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
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
    ImageButton btnplay,btnstop;
    String tenbh;
    //chay nhac
    static MediaPlayer mp;
    int count = 1;
    int totalTime;
    TextView txtbd,txtkt;
    ProgressBar progressBar;

//    private MyService myService;
//    private boolean isServiceConnected;
//    private ServiceConnection mServiceConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder iBinder) {
//            MyService.MyBinder myBinder = (MyService.MyBinder) iBinder;
//            myService = myBinder.getMusicBoundService();
//            myService.startMusic();
//            isServiceConnected = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            isServiceConnected = false;
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img_casi = findViewById(R.id.img_casi2);
        tv_tenbh = findViewById(R.id.tv_tenbh3);
        tv_tencs = findViewById(R.id.tv_tencs3);
        tv_thoiluong = findViewById(R.id.tv_ketthuc);
        btnplay = findViewById(R.id.btn_play2);
        //btnstop = findViewById(R.id.btn_stp);
        //phat nhac
        txtbd = findViewById(R.id.tv_batdau);
        txtkt = findViewById(R.id.tv_ketthuc);
        progressBar = findViewById(R.id.progressBar2);


        Intent intent = getIntent();
        if(intent!=null){
            //ham 1
            if(mp != null){
                mp.stop();
            }
            mucsic = (Mucsic) intent.getSerializableExtra("music");
            img_casi.setImageResource(mucsic.getAnh());
            tv_tenbh.setText(mucsic.getTenbh());
            Toast.makeText(MainActivity2.this,tv_tenbh.getText(),Toast.LENGTH_LONG);
            tv_tencs.setText(mucsic.getTencs());
            tv_thoiluong.setText(mucsic.getThoiluong());

            tenbh = mucsic.getTenbh();

            totalTime = MediaPlayer.create(getBaseContext(),mucsic.getResource()).getDuration();
            //ham 2
            mp = MediaPlayer.create(getApplicationContext(),mucsic.getResource());
            //Toast.makeText(MainActivity2.this,"da co nhac",Toast.LENGTH_SHORT).show();
        }



        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {//ham 3
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp = MediaPlayer.create(getApplicationContext(),mucsic.getResource());
                mp.start();
                Toast.makeText(MainActivity2.this,"chay di nhac",Toast.LENGTH_SHORT).show();
            }
        });
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying() && mp!=null) {
                    mp.pause();//pausse laf dung lai khidang chay, stop la kill bai nhac luon hay sao ay
                    btnplay.setImageResource(R.drawable.ic_pause);
                    Toast.makeText(MainActivity2.this,"Pause",Toast.LENGTH_SHORT).show();
                }
                else if(mp.isPlaying()==false && mp!= null){
                    mp.start();
                    btnplay.setImageResource(R.drawable.nutplay);
                    Toast.makeText(MainActivity2.this,"Play",Toast.LENGTH_SHORT).show();
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