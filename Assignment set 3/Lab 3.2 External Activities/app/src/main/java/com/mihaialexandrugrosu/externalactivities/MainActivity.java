package com.mihaialexandrugrosu.externalactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void openMap(View view)
    {
        // Map point based on address
        Uri location = Uri.parse("geo:0,0?q=Oulu+University+of+Applied+Sciences,+Kotkantie+Campus");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

    public void createCall(View view)
    {
        Uri number = Uri.parse("tel:+358206110200");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void go(View view)
    {
        try {
            Uri webpage = Uri.parse(editText.getText().toString());
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Bad request. (probably missing http:)", Toast.LENGTH_SHORT).show();
        }

    }
}
