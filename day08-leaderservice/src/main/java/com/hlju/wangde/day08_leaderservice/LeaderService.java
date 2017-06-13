package com.hlju.wangde.day08_leaderservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LeaderService extends Service {
    public LeaderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return new mm();
    }

    class mm extends Binder {
        public void qianxian() {
            banzheng();
        }
    }

    public void banzheng() {
        System.out.println("成功办证");
    }
}
