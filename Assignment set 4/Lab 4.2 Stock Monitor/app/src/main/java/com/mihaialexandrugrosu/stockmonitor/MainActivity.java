package com.mihaialexandrugrosu.stockmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;

    ArrayList<String> items = new ArrayList<>();

    String[] companies = { "Apple", "Alphabet (Google)", "Facebook", "Nokia"};
    String[] stockIDs = { "AAPL", "GOOGL", "FB", "NOK"};

    RequestQueue queue;

    final String firstPart = "https://financialmodelingprep.com/api/company/price/";
    final String secondPart = "?datatype=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("AAA", "onCreate: ");
        listView = findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        queue = Volley.newRequestQueue(this);

        Log.d("AAA", "performing searches");
        for (int i = 0; i < companies.length; i++)
        {
            performSearch(stockIDs[i], companies[i]);
        }
    }

    private void performSearch(final String stockID, final String company)
    {
        String url = firstPart + stockID + secondPart;

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try {
                            JSONObject jsonObject = response.getJSONObject(stockID);

                            Log.d("AAA", "response reached ");
                            String value = company + ": " + jsonObject.getDouble("price") + " USD";
                            items.add(value);
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("AAA", "onResponse: Error parsing.");
                        }
                    }
                }, new Response.ErrorListener()
                {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.d("AAA", "onErrorResponse: Error");
                    }
                });
        queue.add(jsonObjectRequest);
    }
}
