package com.mihaialexandrugrosu.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class TimerCountdownActivity extends AppCompatActivity {

    TextView countdown;

    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_countdown);

        activity = this;

        countdown = findViewById(R.id.countdown);

        Intent intent = getIntent();

        long time = intent.getLongExtra("Time", 10);
        time *= 1000; // converting seconds to millis
        new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                countdown.setText(millisUntilFinished / 1000 + "");
            }

            public void onFinish() {
                countdown.setText("done!");
                activity.finish();
            }
        }.start();

    }
}
