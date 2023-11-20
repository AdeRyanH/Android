package com.deryan.hellohello;

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

public class MainActivity2 extends AppCompatActivity {

    private TextView nomorText,namaText,text1,text2;
    private String url;
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        data();
        load();
    }

    private void data(){
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        String nama = intent.getStringExtra("nama");
        String nomor = intent.getStringExtra("nomor");

        namaText = (TextView) findViewById(R.id.nama);
        nomorText = (TextView) findViewById(R.id.nomor);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);


        namaText.setText(nama);
        nomorText.setText(nomor);
    }

    private void load(){
        text1.setText("");
        text2.setText("");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    namaText.setText(response.getString("name"));
                    nomorText.setText(String.format("#%03d", response.getInt("id")));

                    JSONArray typeentries = response.getJSONArray("types");
                    for (int i = 0; i < typeentries.length(); i++){
                        JSONObject typeentry = typeentries.getJSONObject(i);
                        int slot = typeentry.getInt("slot");
                        String type = typeentry.getJSONObject("type").getString("name");

                        if (slot == 1){
                            text1.setText(type);
                        } else if (slot == 2) {
                            text2.setText(type);
                        }

                    }
                } catch (JSONException e) {
                    Log.e("cs50", "pokemon json error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("cs50","pok det list");
            }
        });
        requestQueue.add(request);
    }
}