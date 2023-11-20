package com.deryan.apicorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {

    private TextView country,cases,death,recovered,update;
    private RequestQueue requestQueue;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        country = (TextView) findViewById(R.id.country);
        cases = (TextView) findViewById(R.id.cases);
        death = (TextView) findViewById(R.id.death);
        recovered = (TextView) findViewById(R.id.recovered);
        update = (TextView) findViewById(R.id.update);

        detail();
    }

    protected void detail(){

        Intent intent = getIntent();
        url = "https://covid-19.dataflowkit.com/v1/" + intent.getStringExtra("country");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    country.setText(response.getString("Country_text"));
                    cases.setText(response.getString("Total Cases_text"));
                    death.setText(response.getString("Total Deaths_text"));
                    recovered.setText(response.getString("Total Recovered_text"));
                    update.setText(response.getString("Last Update"));
                } catch (JSONException e) {
                    Log.e("cs50", "corona json error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("cs50","cor det list");
            }
        });
        requestQueue.add(request);
    }
}