package com.hlju.wangde.day01_dial;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Activity创建时自动执行
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取布局文件中定义按钮
        Button call = (Button)findViewById(R.id.Call);
        call.setOnClickListener(new MyListener());
    }
    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
//            System.out.println("拨号");
            EditText phonenum = (EditText)findViewById(R.id.phonenum);
            String number = phonenum.getText().toString();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+number));
            startActivity(intent);
        }
    }
}
