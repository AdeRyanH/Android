package com.deryan.hellohello;

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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;

public class Pokadapter extends RecyclerView.Adapter<Pokadapter.PokemonViewHolder> {

    public class PokemonViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ConstraintLayout containerView;
        public  PokemonViewHolder(@NonNull View view){
            super(view);
            textView = view.findViewById(R.id.pokemon_row_text_view);
            containerView = view.findViewById(R.id.baris);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pokclass current = (Pokclass) containerView.getTag();
                    Intent intent = new Intent(view.getContext(), MainActivity2.class);
                    intent.putExtra("url",current.getUrl());
//                    intent.putExtra("nomor",current.getNumber());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
//    private List<Pokclass> pokemon = Arrays.asList(
//            new Pokclass("Bulbasaur", 1),
//            new Pokclass("Ivysaur", 2),
//            new Pokclass("Venysaur", 3)
//    );
    private List<Pokclass> pokemon = new ArrayList<>();
    private RequestQueue requestQueue;

    Pokadapter(Context context){
        requestQueue = Volley.newRequestQueue(context);
        loadPokemon();
    }


    public void loadPokemon(){
        String url = "https://pokeapi.co/api/v2/pokemon?limit=5";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");
                    for (int i = 0 ; i< results.length(); i++){
                        JSONObject result = results.getJSONObject(i);
                        String name = result.getString("name");
                        pokemon.add(new Pokclass(
                                name.substring(0,1).toUpperCase() + name.substring(1),
                                result.getString("url")
                        ));
                    }notifyDataSetChanged();
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
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_row,parent,false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokclass current = pokemon.get(position);
        holder.textView.setText(current.getName());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

}
