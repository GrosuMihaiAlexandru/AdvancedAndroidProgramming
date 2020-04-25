package com.mihaialexandrugrosu.morecomplexuiprogrammatically;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String[] COUNTRIES = new String[] {
            "Afganistan", "Albania", "Algeria", "American Samoa", "Andorra",
            "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
            "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        LinearLayout verticalLayout = new LinearLayout(this);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(verticalLayout);

        LinearLayout horizontalLayout = new LinearLayout(this);
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        horizontalLayout.setGravity(Gravity.CENTER);

        verticalLayout.addView(horizontalLayout);

        Button addButton = new Button(this);
        addButton.setText("ADD");
        horizontalLayout.addView(addButton);

        Button editButton = new Button(this);
        editButton.setText("EDIT");
        horizontalLayout.addView(editButton);

        Button removeButton = new Button(this);
        removeButton.setText("REMOVE");
        horizontalLayout.addView(removeButton);

        EditText editText = new EditText(this);
        verticalLayout.addView((editText));

        ListView listview = new ListView(this);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        listview.setAdapter(adapter);
        verticalLayout.addView((listview));

    }
}
