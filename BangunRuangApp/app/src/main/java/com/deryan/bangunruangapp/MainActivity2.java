package com.deryan.bangunruangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.luas);
        textView.setText(message);

        String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        TextView textView2 = (TextView) findViewById(R.id.volume);
        textView2.setText(message2);

    }
}