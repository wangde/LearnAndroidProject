package com.hlju.wangde.day06_transmitdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        EditText et_one = (EditText) findViewById(R.id.et_one);
        EditText et_two = (EditText) findViewById(R.id.et_two);
        int one = Integer.parseInt(et_one.getText().toString());
        int two = Integer.parseInt(et_two.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("one", one);
        bundle.putInt("two", two);
        intent.putExtras(bundle);
//        intent.putExtra("one",one);
//        intent.putExtra("two",two);
        startActivity(intent);
    }
}
