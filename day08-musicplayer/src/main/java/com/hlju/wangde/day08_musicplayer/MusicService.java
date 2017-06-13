package com.hlju.wangde.day08_musicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return new MusicController();
    }

    class MusicController extends Binder implements ControllerInterface {

        @Override
        public void play() {
            MusicService.this.play();
        }

        @Override
        public void pauser() {
            MusicService.this.pause();
        }
    }

    public void play() {

    }

    public void pause() {

    }

}
