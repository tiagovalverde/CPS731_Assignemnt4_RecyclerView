package com.example.cps731_a4_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    TimerTask timerTask;
    Timer timerLoadingApp;
    private static final int TIMER_DURATION = 5000;

    MediaPlayer mediaPlayerLoadingApp;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.setMediaPlayer();
        this.setTimerTask();
        this.startLoadingTimer();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayerLoadingApp.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayerLoadingApp.stop();
    }

    private void startLoadingTimer() {
        System.out.println(mediaPlayerLoadingApp);
        timerLoadingApp = new Timer();
        timerLoadingApp.schedule(timerTask, TIMER_DURATION);
    }


    private void setMediaPlayer() {
        mediaPlayerLoadingApp = new MediaPlayer();
        mediaPlayerLoadingApp = MediaPlayer.create(this, R.raw.mario_bros);
    }

    private void setTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        };
    }
}