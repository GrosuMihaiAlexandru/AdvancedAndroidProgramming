package com.mihaialexandrugrosu.uiprogrammatically;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final Button gameButton = new Button(this);
        gameButton.setText("You have pressed this button " + count + " times.");
        setContentView(gameButton);

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                gameButton.setText("You have pressed this button " + count + " times.");
            }
        });
    }
}
