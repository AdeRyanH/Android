package com.deryan.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    * private int digunakan untuk membuat variable untuk integer
    * private TextView digunakan untuk membuat variable untuk textview
    */
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        /*
        * line 24 diatas digunakan untuk mengisi variable mShowCount dengan widget
        */
    }
    /*
    * function countUp digunakan untuk menambah angka di textview saat button countUp ditekan
    * */
    public void countUp(View view) {
        if (mCount < 10)
            mCount++;

        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    /*
    * function showToast digunakan untuk memunculkan text massage
    * */
    public void showToast(View view) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, R.string.toast_message, Toast.LENGTH_LONG);
        toast.show();

    }

}