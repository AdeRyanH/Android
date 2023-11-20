package com.deryan.saveinstanceactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText angka1;
    private EditText angka2;
    private EditText angka3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1 = (EditText) findViewById(R.id.angka1);
        angka2 = (EditText) findViewById(R.id.angka2);
        angka3 = (EditText) findViewById(R.id.angka3);
    }

    public void hasil(View view) {
        if (!TextUtils.isEmpty(angka1.getText()) && !TextUtils.isEmpty(angka2.getText()) && !TextUtils.isEmpty(angka3.getText())) {
            int satu = Integer.valueOf(angka1.getText().toString().trim());
            int dua = Integer.valueOf(angka2.getText().toString().trim());
            int tiga = Integer.valueOf(angka3.getText().toString().trim());
            int jumlah = satu + dua;

            Context context = getApplicationContext();
            if (jumlah == tiga){
                Toast toast = Toast.makeText(context, "Benar", Toast.LENGTH_SHORT);
                toast.show();
            }else {
                Toast toast = Toast.makeText(context, "Salah", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}