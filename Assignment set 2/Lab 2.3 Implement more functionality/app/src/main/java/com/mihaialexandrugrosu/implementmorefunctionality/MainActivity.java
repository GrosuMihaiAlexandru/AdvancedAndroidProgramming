package com.mihaialexandrugrosu.implementmorefunctionality;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String[] COUNTRIES = new String[] {
            "Afganistan", "Albania", "Algeria", "American Samoa", "Andorra",
            "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
            "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
    };

    ArrayList<String> countries = new ArrayList<>();

    EditText editText;
    ListView listview;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        GenerateList();

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

        final Button editButton = new Button(this);
        editButton.setText("EDIT");
        horizontalLayout.addView(editButton);

        Button removeButton = new Button(this);
        removeButton.setText("REMOVE");
        horizontalLayout.addView(removeButton);

        editText = new EditText(this);
        verticalLayout.addView((editText));

        listview = new ListView(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        listview.setAdapter(adapter);
        verticalLayout.addView((listview));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals(""))
                {
                    countries.add(editText.getText().toString());
                    editText.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals(""))
                {
                    countries.remove(editText.getText().toString());
                    editText.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void GenerateList()
    {
        for (int i = 0; i < COUNTRIES.length; i++)
        {
            countries.add(COUNTRIES[i]);
        }
    }
}
