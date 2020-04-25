package com.mihaialexandrugrosu.zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;

    boolean mammals = true;

    Context context;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);

        mediaPlayer = MediaPlayer.create(context, R.raw.bear);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mammals)
                {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(context, R.raw.bear);
                    mediaPlayer.start();
                }
                else
                {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(context, R.raw.huuhkaja_norther_eagle_owl);
                    mediaPlayer.start();
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mammals)
                {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(context, R.raw.wolf);
                    mediaPlayer.start();
                }
                else
                {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(context, R.raw.peippo_chaffinch);
                    mediaPlayer.start();
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mammals)
                {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(context, R.raw.elephant);
                    mediaPlayer.start();
                }
                else
                {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(context, R.raw.peukaloinen_wren);
                    mediaPlayer.start();
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mammals)
                {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(context, R.raw.lamb);
                    mediaPlayer.start();
                }
                else
                {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(context, R.raw.punatulkku_northern_bullfinch);
                    mediaPlayer.start();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mammals:
                image1.setImageResource(R.drawable.bear);
                image2.setImageResource(R.drawable.wolf);
                image3.setImageResource(R.drawable.elephant);
                image4.setImageResource(R.drawable.lamb);

                mammals = true;
                return true;
            case R.id.birds:
                image1.setImageResource(R.drawable.huuhkaja);
                image2.setImageResource(R.drawable.peippo);
                image3.setImageResource(R.drawable.peukaloinen);
                image4.setImageResource(R.drawable.punatulkku);

                mammals = false;
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
