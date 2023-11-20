package com.deryan.apicorona;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CoronaAdapter extends RecyclerView.Adapter<CoronaAdapter.CoronaViewHolder>{
    public class CoronaViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ConstraintLayout containerView;
        public  CoronaViewHolder(@NonNull View view){
            super(view);
            textView = view.findViewById(R.id.row);
            containerView = view.findViewById(R.id.row_layout);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CoronaClass current = (CoronaClass) containerView.getTag();
                    Intent intent = new Intent(view.getContext(), SecondActivity.class);
                    intent.putExtra("country",current.getCountry());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
    private List<CoronaClass> corona = new ArrayList<>();
    private RequestQueue requestQueue;

    CoronaAdapter(Context context){
        requestQueue = Volley.newRequestQueue(context);
        loadPokemon();
    }


    public void loadPokemon(){
        String url = "https://covid-19.dataflowkit.com/v1";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    for (int i = 0 ; i< response.length(); i++){
                        JSONObject result = response.getJSONObject(i);
                        String country = result.getString("Country_text");
                        String cases = result.getString("Total Cases_text");
                        String deaths = result.getString("Total Deaths_text");
                        String recovered = result.getString("Total Recovered_text");
                        String update = result.getString("Last Update");
                        corona.add(new CoronaClass(
                                country,
                                cases,
                                deaths,
                                recovered,
                                update
                                ));

                        notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    Log.e("cs50", "json error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("cs50","pok eror list");
            }
        });
        requestQueue.add(request);
    }

    @NonNull
    @Override
    public CoronaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new CoronaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaViewHolder holder, int position) {
        CoronaClass current = corona.get(position);
        holder.textView.setText(current.getCountry());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return corona.size();
    }
}
