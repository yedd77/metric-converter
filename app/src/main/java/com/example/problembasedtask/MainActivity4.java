package com.example.problembasedtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.ims.ImsManager;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ImageView backbtn = (ImageView) findViewById(R.id.backbtn);

        backbtn.setOnClickListener(View ->{
            Intent mainPage = new Intent(getBaseContext(), MainActivity.class);
            startActivity(mainPage);
        });

    }
}

//activity_main.xml
//MainActivity.java
//activity_main4.xml
//MainActivity.java
//string.xml