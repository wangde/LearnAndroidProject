package com.hlju.wangde.dsy08_register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenOnOFFReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_ON.equals(action)) {
            System.out.println("屏幕开启");

        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            System.out.println("屏幕关闭");
        }
    }
}
