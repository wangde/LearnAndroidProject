package com.hlju.wangde.day02_istore;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText)findViewById(R.id.et_name);
        et_password = (EditText)findViewById(R.id.et_password);
        readAccount();

    }

    private void readAccount(){
        //读取文件，回显数据

//        File file = new File("data/data/com.hlju.wangde.day02_istore/info.txt");
        //getFilesDir()返回一个file对象封装的路径是data/data/com.hlju.wangde.day02_istore/files
//        File file = new File(getFilesDir(),"info.txt");
        //getCacheDir()返回一个file对象封装的路径是data/data/com.hlju.wangde.day02_istore/cache
        File file = new File(getCacheDir(),"info.txt");
        if(file.exists()) {
            try {
                SharedPreferences sp = getSharedPreferences("info",MODE_PRIVATE);
                String name = sp.getString("name","");
                String password = sp.getString("password","");
                et_name.setText(name);
                et_password.setText(password);
//                FileInputStream fis = new FileInputStream(file);
//                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//                //读取文件中文本
//                String text = br.readLine();
//                String s[] = text.split("&&");
//                et_name.setText(s[0]);
//                et_password.setText(s[1]);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void login(View view){


        String name = et_name.getText().toString();
        String password = et_password.getText().toString();

        CheckBox  ch_remember = (CheckBox)findViewById(R.id.ch_remember);

        if(ch_remember.isChecked()){
            //把账号密码保存在本地
//            File file = new File(getFilesDir(),"info.txt");
            File file = new File(getCacheDir(),"info.txt");
            try{
                //生成XML文件存储
//                SharedPreferences sp = getSharedPreferences("info",MODE_PRIVATE);
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putString("name",name);
//                editor.putString("password",password);
//                editor.commit();
                FileOutputStream fos = new FileOutputStream(file);
                fos.write((name +"&&"+password).getBytes());
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}
