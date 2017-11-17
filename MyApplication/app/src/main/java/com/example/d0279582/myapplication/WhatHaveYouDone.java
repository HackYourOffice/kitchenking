package com.example.d0279582.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WhatHaveYouDone extends AppCompatActivity {
    Button dishwasherin;
    Button dishwasherout;
    Button mop;
    int points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_have_you_done);

        dishwasherin = (Button) findViewById(R.id.activity_button_dishwasher_in);
        dishwasherout = (Button) findViewById(R.id.activity_button_dishwasher_out);
        mop = (Button) findViewById(R.id.activity_button_mop);

        dishwasherin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                points = 5;
                getBack();
            }
        });

        dishwasherout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                points = 3;
                getBack();
            }
        });

        mop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                points = 1;
                getBack();
            }
        });

    }

    private void getBack() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_POINTS", points+"");
        startActivity(intent);
    }
}
