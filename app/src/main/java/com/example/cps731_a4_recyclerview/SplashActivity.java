package com.example.cps731_a4_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    TimerTask timerTask;
    Timer timerLoadingApp;
    private static final int TIMER_DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.setTimerTask();

        timerLoadingApp = new Timer();
        timerLoadingApp.schedule(timerTask, TIMER_DURATION);
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