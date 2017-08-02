package com.hlju.wangde.day10_mycontentprovide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hlju.wangde.day10_mycontentprovide.db.MyOpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        PersonProvide personProvide = new PersonProvide();
        MyOpenHelper oh = new MyOpenHelper(getBaseContext());
        oh.getWritableDatabase();


    }
}
