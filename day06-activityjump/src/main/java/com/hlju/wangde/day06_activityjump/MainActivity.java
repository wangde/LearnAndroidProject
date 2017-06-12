package com.hlju.wangde.day06_activityjump;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:1555555555"));
        startActivity(intent);
    }

    public void click2(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        intent.setData(Uri.parse("sdd"));
        startActivity(intent);
    }

    public void click3(View view) {
        Intent intent = new Intent();
        intent.setAction("w.d");
//        intent.setData(Uri.parse("xiaode:123"));
        intent.setDataAndType(Uri.parse("xiaode:123"), "text/name");
        startActivity(intent);
    }
}
