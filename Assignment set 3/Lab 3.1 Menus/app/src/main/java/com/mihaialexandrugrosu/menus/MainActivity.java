package com.mihaialexandrugrosu.menus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        layout = findViewById(R.id.layout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.colors, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.red:
                textView.setText("RED");
                layout.setBackgroundColor(Color.RED);
                return true;
            case R.id.green:
                textView.setText("GREEN");
                layout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.blue:
                textView.setText("BLUE");
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.yellow:
                textView.setText("YELLOW");
                layout.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
