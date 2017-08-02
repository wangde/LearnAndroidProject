package com.hlju.wangde.day10_contentobserver;

import android.content.ContentResolver;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册内容观察者，观察者生效可以接收内容提供者通知
        ContentResolver resolver = getContentResolver();
        resolver.registerContentObserver(Uri.parse("content://sms"),
                true,  //如果为true,以此URI作为开头的数据改变，该内容观察者都会收到通知
                new MyObserver(new Handler()));
    }

    class MyObserver extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public MyObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            System.out.println("收到数据库改变");
        }
    }
}
