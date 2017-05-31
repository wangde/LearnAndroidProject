package com.hlju.wangde.buttonclick;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button)findViewById(R.id.bt1);
//        bt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("单击button1");
//            }
//        });
        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println("单击button1");
    }
    public void click(View view){
        System.out.println("单击button2");
    }
}
