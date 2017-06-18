package com.hlju.wangde.day09_videoplay;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    int pregress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.sv);
        final SurfaceHolder sh = surfaceView.getHolder();

//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                super.run();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        MediaPlayer player = new MediaPlayer();
//                        player.reset();
//                        try {
//                            player.setDataSource("sdcard/VID_20151231_225821.mp4");
//                            player.setDisplay(sh);
//                            player.prepare();
//                            player.start();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//        };
//        thread.start();
        sh.addCallback(new SurfaceHolder.Callback() {
            //surfaceview创建时调用
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (player == null) {
                    player = new MediaPlayer();
                    player.reset();
                    try {
                        player.setDataSource("sdcard/VID_20151231_225821.mp4");
                        player.setDisplay(sh);
                        player.prepare();
                        player.seekTo(pregress);
                        player.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            //surfaceview销毁时调用
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (player != null) {
                    pregress = player.getCurrentPosition();
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });
    }
}
