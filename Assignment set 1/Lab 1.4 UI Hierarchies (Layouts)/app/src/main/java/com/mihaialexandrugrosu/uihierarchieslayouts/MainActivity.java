package com.mihaialexandrugrosu.uihierarchieslayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] COUNTRIES = new String[] {
                "Afganistan", "Albania", "Algeria", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
                "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
        };

        ListView myListView = (ListView) findViewById(R.id.country_list_view);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        myListView.setAdapter(aa);
    }

}
