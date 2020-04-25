package com.mihaialexandrugrosu.moreui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onHorizontalClick(View v)
    {
        Intent intent = new Intent(this, LinearLayout_horizontal.class);
        startActivity(intent);
    }

    public void onVerticalClick(View v)
    {
        Intent intent = new Intent(this, LinearLayout_vertical.class);
        startActivity(intent);
    }

    public void onCoordinatorClick(View v)
    {
        Toast.makeText(this, "This package is part of the Android support library which is no longer maintained. The support library has been superseded by AndroidX which is part of Jetpack. We recommend using the AndroidX libraries in all new projects. You should also consider migrating existing projects to AndroidX.", Toast.LENGTH_LONG).show();
    }
}
