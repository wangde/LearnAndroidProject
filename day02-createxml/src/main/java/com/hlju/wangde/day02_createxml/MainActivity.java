package com.hlju.wangde.day02_createxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;

import com.hlju.wangde.sms.Sms;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Sms> smsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smsList = new ArrayList<Sms>();
        for (int i =0 ; i<10;i++){
            Sms sms = new Sms("你好"+i,System.currentTimeMillis(),1,"1504555");
            smsList.add(sms);
        }
    }
    public void click(View view){
//        StringBuffer sb = new StringBuffer();
//        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
//        sb.append("<smss>");
//        for(Sms sms: smsList){
//            sb.append("<sms>");
//
//            sb.append("<body>");
//            sb.append(sms.getBody());
//            sb.append("</body>");
//
//            sb.append("<date>");
//            sb.append(sms.getDate());
//            sb.append("</date>");
//
//            sb.append("<type>");
//            sb.append(sms.getType());
//            sb.append("</type>");
//
//            sb.append("<address>");
//            sb.append(sms.getAddress());
//            sb.append("</address>");
//
//            sb.append("</sms>");
//
//        }
//        sb.append("</smss>");
//
//        File file = new File("sdcard/sms.xml");
//        try{
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(sb.toString().getBytes());
//
//        }catch (Exception e){e.printStackTrace();}
        //获取XML序列化器
        XmlSerializer xs = Xml.newSerializer();
        File file = new File("sdcard/sms.xml");
        FileOutputStream fos;
        try{
            fos = new FileOutputStream(file);
            //初始化
            xs.setOutput(fos, "utf-8");
            //开始生成xml文件
            //生成头结点
            xs.startDocument("utf-8",true);
            xs.startTag(null,"smss");
            for(Sms sms : smsList){
                xs.startTag(null,"sms");

                xs.startTag(null,"body");
                xs.text(sms.getBody());
                xs.endTag(null,"body");

                xs.startTag(null,"type");
                xs.text(sms.getType()+"");
                xs.endTag(null,"type");

                xs.startTag(null,"date");
                xs.text(sms.getDate()+"");
                xs.endTag(null,"date");

                xs.startTag(null,"address");
                xs.text(sms.getAddress());
                xs.endTag(null,"address");

                xs.endTag(null,"sms");
            }
            xs.endTag(null,"smss");
            //生成尾节点
            //告知生成器结束
            xs.endDocument();
        }catch (Exception e){e.printStackTrace();}

    }
}
