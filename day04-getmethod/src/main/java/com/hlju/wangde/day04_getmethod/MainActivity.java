package com.hlju.wangde.day04_getmethod;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            Toast.makeText(MainActivity.this,(String)msg.obj,Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
        }
    };
    public void login(View view ){

        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_pass = (EditText) findViewById(R.id.et_pass);
        final String name = et_name.getText().toString();
        final String pass = et_pass.getText().toString();
        Thread thread = new Thread(){
            @Override
            public void run() {
                String path = "http://192.168.3.150:8080/Web2/Servlet/Login?name="+name+"&pass="+pass;
                try{
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    if(httpURLConnection.getResponseCode()==200){
                        InputStream is = httpURLConnection.getInputStream();
                        String text = Tools.getTextFromStream(is);
                        Message msg = handler.obtainMessage();
                        msg.obj = text;
                        handler.sendMessage(msg);

                    }
                }catch (Exception e ){e.printStackTrace();}
                super.run();
            }
        };
        thread.start();
    }
}
