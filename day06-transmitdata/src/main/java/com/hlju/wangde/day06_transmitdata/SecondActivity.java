package com.hlju.wangde.day06_transmitdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int one = bundle.getInt("one");
        int two = bundle.getInt("two");
//        int one = intent.getIntExtra("one",0);
//        int two = intent.getIntExtra("two",0);
        int sum = one + two;


        Toast.makeText(this, sum + "", Toast.LENGTH_SHORT).show();
    }
}
