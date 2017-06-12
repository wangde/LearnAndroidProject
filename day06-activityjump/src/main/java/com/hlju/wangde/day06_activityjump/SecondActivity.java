package com.hlju.wangde.day06_activityjump;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //获取启动该activity的意图对象
        Intent intent = getIntent();
        Uri uri = intent.getData();
        System.out.println("uri:" + uri);
    }
}
