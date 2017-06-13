package com.hlju.wangde.day08_runservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyConn conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = new MyConn();
    }

    public void start(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stop(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    public void bind(View view) {
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void unbind(View view) {
        unbindService(conn);
    }

    class MyConn implements ServiceConnection {

        //到服务的连接被建立此方法被调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        //到服务的连接被中断，此方法被调用
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}

