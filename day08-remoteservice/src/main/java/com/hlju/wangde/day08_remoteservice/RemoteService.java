package com.hlju.wangde.day08_remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;


public class RemoteService extends Service {
    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        System.out.println("绑定");
//        throw new UnsupportedOperationException("Not yet implemented");
        return new remotemid();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("解绑");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        System.out.println("创建");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("开始");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("销毁");
        super.onDestroy();
    }

    public void remote() {
        System.out.println("remote被访问");
    }

    class remotemid extends PublicBusiness.Stub {


        @Override
        public void middle() throws RemoteException {
            remote();
        }
    }

//    private final PublicBusiness.Stub pb = new PublicBusiness.Stub{
//
//    }


}
