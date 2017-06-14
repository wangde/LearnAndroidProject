package com.hlju.wangde.dsy08_register;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.text.NoCopySpan;

public class RegisterService extends Service {
    public RegisterService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {
        //注册广播接收者
        //创建广播接受者对象
        ScreenOnOFFReceiver receiver = new ScreenOnOFFReceiver();
        //创建意图过滤器对象
        IntentFilter filter = new IntentFilter();
        //指定接收什么广播
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(receiver, filter);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        ScreenOnOFFReceiver receiver = new ScreenOnOFFReceiver();
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}
