package com.hlju.wangde.runremoteservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.DisconnectCause;
import android.view.View;

import com.hlju.wangde.day08_remoteservice.PublicBusiness;

public class MainActivity extends AppCompatActivity {

    Myconn conn;
    PublicBusiness pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = new Myconn();
    }

    public void start(View view) {
        Intent intent = new Intent();
        intent.setAction("com.hlju.remote");
        intent.setPackage("com.hlju.wangde.day08_remoteservice");
        startService(intent);
    }

    public void stop(View view) {
        Intent intent = new Intent();
        intent.setAction("com.hlju.remote");
        intent.setPackage("com.hlju.wangde.day08_remoteservice");
        stopService(intent);
    }

    public void bind(View view) {
        Intent intent = new Intent();
        intent.setAction("com.hlju.remote");
        intent.setPackage("com.hlju.wangde.day08_remoteservice");
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void unbind(View view) {
        unbindService(conn);
    }

    class Myconn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("remote" + service);
            pb = PublicBusiness.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    public void click(View view) {
        try {
            pb.middle();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
