package com.deryan.hellohello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view);
        adapter = new Pokadapter(getApplicationContext());
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        txt = findViewById(R.id.txt);
        apis();
    }

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private JsonObjectRequest json;
    private String url = "https://pokeapi.co/api/v2/pokemon?limit=3";
    private void apis(){
// RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        // String Request initialized
//        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>()
        json = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>()

        {
            @Override
            public void onResponse(JSONObject response) {

//                System.out.println(response);
//                Toast.makeText(getApplicationContext(), "Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
                txt.setText("Response is: " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("status", "Error :" + error.toString());
            }
        });

        mRequestQueue.add(json);
    }
}