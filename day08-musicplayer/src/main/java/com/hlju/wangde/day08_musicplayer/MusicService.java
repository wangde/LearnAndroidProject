package com.hlju.wangde.day08_musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MusicService extends Service {
    public MusicService() {
    }

    MediaPlayer player;
    Timer timer;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return new MusicController();
    }

    @Override
    public void onCreate() {
        player = new MediaPlayer();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        //销毁player
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        player.stop();
        player.release();
        super.onDestroy();
    }

    public void play() {
        player.reset();
        try {
//            String path ="android:resource://"+getPackageName()+"/"+R.raw.sunshinegirl;
            Uri uri = Uri.parse("android:resource://" + getPackageName() + "/" + R.raw.sunshinegirl);
            player.setDataSource("sdcard/sunshinegirl.mp3");
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    player.start();
                    addTimer();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        player.pause();

    }

    public void continuePlay() {
        player.start();
    }

    public void addTimer() {

        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int duration = player.getDuration();
                int currentPosition = player.getCurrentPosition();
                Message msg = MainActivity.handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("duration", duration);
                bundle.putInt("currentPosition", currentPosition);
                msg.setData(bundle);
                MainActivity.handler.sendMessage(msg);
            }
        }, 5, 500);

    }

    public void seekTo(int progress) {
        player.seekTo(progress);
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

        @Override
        public void continuePlay() {
            MusicService.this.continuePlay();

        }

        @Override
        public void seekTo(int progress) {
            MusicService.this.seekTo(progress);
        }
    }

}
