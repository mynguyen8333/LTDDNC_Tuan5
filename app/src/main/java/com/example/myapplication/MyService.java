package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MyBinder mBinder = new MyBinder();
    private MediaPlayer mMediaPlayer;
    private Mucsic mucsic;


    public class MyBinder extends Binder {
        MyService getMusicBoundService(){
            return MyService.this;
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MusicBoundService","onBind");
        mucsic = (Mucsic) intent.getSerializableExtra("key1");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MusicBoundService","onCreate");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("MusicBoundService","onUnBind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MusicBoundService","onDetroy");
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void startMusic(){
        if(mMediaPlayer == null){
            mMediaPlayer = MediaPlayer.create(getApplicationContext(),mucsic.getResource());
        }
        mMediaPlayer.start();
    }

}
