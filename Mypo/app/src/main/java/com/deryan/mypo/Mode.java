package com.deryan.mypo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Mode extends AppCompatActivity {
    private Switch switchMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        switchMode = findViewById(R.id.mode);
        switchCheck();
    }
    private void switchCheck(){
        int currentNightMode = AppCompatDelegate.getDefaultNightMode();
        switchMode.setChecked(currentNightMode == AppCompatDelegate.MODE_NIGHT_YES);
        switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int newNightMode = isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO;
                AppCompatDelegate.setDefaultNightMode(newNightMode);
            }
        });
    }
}