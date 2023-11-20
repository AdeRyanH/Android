package com.deryan.mypo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView namaText,tahunText,deskripsiText;
    private ImageView gambarText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        Detail();
    }

    private void Detail(){
        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String tahun = intent.getStringExtra("tahun");
        String deskripsi = intent.getStringExtra("deskripsi");
        int gambar = intent.getIntExtra("gambar",0);

        namaText = (TextView) findViewById(R.id.nama);
        tahunText = (TextView) findViewById(R.id.tahun);
        deskripsiText = (TextView) findViewById(R.id.deskripsi);
        gambarText = (ImageView) findViewById(R.id.gambar);

        namaText.setText(nama);
        tahunText.setText(tahun);
        deskripsiText.setText(deskripsi);
        gambarText.setImageResource(gambar);
    }
}