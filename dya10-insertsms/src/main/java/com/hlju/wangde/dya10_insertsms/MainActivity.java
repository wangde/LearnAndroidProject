package com.hlju.wangde.dya10_insertsms;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.Settings;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertSms(View view) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ContentResolver resolver = getContentResolver();
                ContentValues values = new ContentValues();
                values.put("address", 95555);
                values.put("date", System.currentTimeMillis());
                values.put("type", 1);
                values.put("body", "您收到转转100000000000000000000000");
//                resolver.insert(Uri.parse("content://sms"),values);Sms.Inbox.CONTENT_URI
                resolver.insert(Uri.parse("content://sms"), values);
            }
        };
        thread.start();

    }
}
