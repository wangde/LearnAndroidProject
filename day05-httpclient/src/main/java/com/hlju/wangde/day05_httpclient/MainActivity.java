package com.hlju.wangde.day05_httpclient;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MainActivity.this, (String) msg.obj, Toast.LENGTH_LONG).show();
            super.handleMessage(msg);
        }
    };

    public void click(View v) {
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_pass = (EditText) findViewById(R.id.et_pass);

        String name = et_name.getText().toString();
        String pass = et_pass.getText().toString();

        final String path = "http://192.168.3.150:8080/Web2/Servlet/Login?name=" + name + "&pass=" + pass;

        Thread thread = new Thread() {
            @Override
            public void run() {
                //使用httpClient框架提交
                //创建client对象
                HttpClient client = new DefaultHttpClient();
                //创建get请求对象
                HttpGet get = new HttpGet(path);
                //使用客户端发送get请求
                try {
                    HttpResponse response = client.execute(get);
                    //获取状态行
                    StatusLine line = response.getStatusLine();
                    int code = line.getStatusCode();
                    if (code == 200) {
                        HttpEntity entity = response.getEntity();
                        InputStream inputStream = entity.getContent();
                        String text = Tools.getTextFromStream(inputStream);
                        Message msg = handler.obtainMessage();
                        msg.obj = text;
                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
    }
}
