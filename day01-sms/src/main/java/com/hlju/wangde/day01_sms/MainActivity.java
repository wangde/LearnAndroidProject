package com.hlju.wangde.day01_sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click(View view){
        EditText et_phone = (EditText)findViewById(R.id.phonetext);
        EditText et_sms = (EditText)findViewById(R.id.smstext);
        String phone = et_phone.getText().toString();
        String content = et_sms.getText().toString();
        //直接使用发送短信的API，无需启动系统的短信应用
        SmsManager smsManager = SmsManager.getDefault();
        //把长短信截成若干条短短信
        ArrayList<String> sms = smsManager.divideMessage(content);
        for(String string:sms){
        /*arg0:目标号码
        * arg1:短信中心号码
        * arg2:短信正文
        * arg3：如果不为空则是一个广播
        * arg4：不为空显示目标已经接收短信*/
        smsManager.sendTextMessage(phone,null,string,null,null);
        Toast.makeText(this,"号码："+phone+"  信息："+sms,Toast.LENGTH_LONG).show();
        }
    }
}
