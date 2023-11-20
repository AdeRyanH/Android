package com.deryan.bangunruangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText alassegitiga;
    private EditText tinggi_segitiga;
    private EditText tinggi_prisma;

    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";
    public static final String EXTRA_MESSAGE2 =
            "com.example.android.twoactivities.extra.MESSAGE2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alassegitiga = (EditText) findViewById(R.id.alas_segitiga);
        tinggi_segitiga = (EditText) findViewById(R.id.tinggi_segitiga);
        tinggi_prisma = (EditText) findViewById(R.id.tinggi_prisma);
    }
    public void hasil(View view) {

        if ( !TextUtils.isEmpty(alassegitiga.getText()) && !TextUtils.isEmpty(tinggi_segitiga.getText()) && !TextUtils.isEmpty(tinggi_prisma.getText())){
            double alas_tiga = Double.valueOf(alassegitiga.getText().toString().trim());
            double tinggi_tiga = Double.valueOf(tinggi_segitiga.getText().toString().trim());
            double tinggi_pris = Double.valueOf(tinggi_prisma.getText().toString().trim());
            double set = 0.5;
            double vol = set * alas_tiga * tinggi_tiga * tinggi_pris;
            double luas = 2 * set * alas_tiga * tinggi_tiga + 3 * alas_tiga * tinggi_pris;

            String message = String.valueOf(luas);
            String message2 = String.valueOf(vol);

            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            intent.putExtra(EXTRA_MESSAGE2, message2);
            startActivity(intent);
        }else {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Semua Inputan Harap Diisi", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}