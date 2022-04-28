package com.example.problembasedtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout btnlength = (LinearLayout) findViewById(R.id.length);
        LinearLayout btnweight = (LinearLayout) findViewById(R.id.weight);
        LinearLayout btnInfo = (LinearLayout) findViewById(R.id.infoBtn);

        //Event listener for length page
        btnlength.setOnClickListener(view -> {
            Intent lengthPage = new Intent(getBaseContext(), MainActivity2.class);
            startActivity(lengthPage);
        });

        //Event listener for weight
        btnweight.setOnClickListener(view -> {
            Intent weightPage = new Intent(getBaseContext(), MainActivity3.class);
            startActivity(weightPage);
        });

        //Event listener for info
        btnInfo.setOnClickListener(view ->{
            Intent infoPage = new Intent(getBaseContext(), MainActivity4.class);
            startActivity(infoPage);
        });
    }
}