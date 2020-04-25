package com.mihaialexandrugrosu.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.time);
    }

    public void onStartClick(View view)
    {
        Intent intent = new Intent(this, TimerCountdownActivity.class);
        intent.putExtra("Time", Long.parseLong(editText.getText().toString()));
        startActivity(intent);
    }
}
