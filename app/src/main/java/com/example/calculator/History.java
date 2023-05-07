package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent obj = getIntent();
        String countdata = obj.getStringExtra("listCount");
        Integer total = Integer.parseInt(countdata);

        SharedPreferences getter = getSharedPreferences("data", MODE_PRIVATE);
        LinearLayout Layout = findViewById(R.id.layout);
        Layout.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < total; i++) {
            String historyItem = getter.getString("historydata" + i, "");
            String output = historyItem;


            TextView show = new TextView(getApplicationContext());
            show.setText(output);
            show.setTextSize(25);
            LinearLayout subLayout = new LinearLayout(getApplicationContext());
            subLayout.setOrientation(LinearLayout.HORIZONTAL);
            subLayout.addView(show);

            Layout.addView(subLayout);

        }
    }
}