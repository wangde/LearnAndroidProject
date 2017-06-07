package com.hlju.wangde.day04_imageviewer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    ImageView imageView = (ImageView) findViewById(R.id.imageView);
                    imageView.setImageBitmap((Bitmap) msg.obj);
                    break;
                case 2:
                    Toast.makeText(MainActivity.this,"图片获取失败",Toast.LENGTH_SHORT).show();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    public void click(View v) {
        Toast.makeText(this,"点击",Toast.LENGTH_LONG).show();
        Thread thread = new Thread(){
            @Override
            public void run() {
                String path = "http://pic2.sc.chinaz.com/files/pic/pic9/201705/bpic1572.jpg";
                //发送http请求
                try {
                    //使用网址构造以url对象

                    URL url = new URL(path);
                    //获取连接对象
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    //设置一些属性
                    //设置请求方式
                    connection.setRequestMethod("GET");
                    //设置请求超时
                    connection.setConnectTimeout(8000);
                    //设置读取超时
                    connection.setReadTimeout(8000);
                    //发送请求，建立连接
                    connection.connect();

                    if(connection.getResponseCode() == 200){
                        //获取服务器返回的流
                        InputStream is = connection.getInputStream();
//                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        byte [] b= new byte[1024];
                        int len;
                        File file = new File(getCacheDir(),"dd.jpg");
                        FileOutputStream fos = new FileOutputStream(file);
                        while ((len = is.read(b))!=-1){
                            fos.write(b, 0,len);
                        }
                        fos.close();
                        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        Message msg = handler.obtainMessage();
                        msg.what = 1;
                        msg.obj = bitmap;
                        handler.sendMessage(msg);
                        is.close();

                    }
                    else {
                        handler.sendEmptyMessage(2);
//                        Message msg = handler.obtainMessage();
//                        msg.what = 2;
//                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
//        String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496642369567&di=eac652a3e1bde733d890ca6f75bb99b7&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201601%2F08%2F20160108161200_LaQtr.thumb.700_0.jpeg";
       thread.start();


    }
}
