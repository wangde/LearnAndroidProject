package com.hlju.wangde.day02_logcat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String tag = "Logcat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("This is a Logcat msg");

        Log.e(tag,"This is a Logcat msg");
        Log.v(tag,"This is a Logcat msg");
        Log.i(tag,"This is a Logcat msg");
        Log.d(tag,"This is a Logcat msg");
        Log.w(tag,"This is a Logcat msg");
    }
}
