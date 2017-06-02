package com.hlju.wangde.day03_xmlpullparser;


import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;

import com.hlju.wangde.day03_xmlpullparser.domain.City;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<City> cityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void getweather(View v){
        //获取天气XML文件
        InputStream is = getClassLoader().getResourceAsStream("assets/weather1.xml");

//        File file = new File(Environment.getExternalStorageDirectory(),"weather.xml");

        //获取xmlpull解析器
        XmlPullParser xp = Xml.newPullParser();

        try {
//            FileInputStream is = new FileInputStream(file);
            //初始化
            xp.setInput(is,"utf-8");

            //获取当前节点事件类型
            int type = xp.getEventType();
            City city = null;
            while (type != XmlPullParser.END_DOCUMENT){
                switch (type){
                    case XmlPullParser.START_TAG:
                        if("weather".equals(xp.getName())){
                            cityList = new ArrayList<City>();
                        }
                        else if ("city".equals(xp.getName())){
                             city = new City();
                        }
                        else if ("name".equals(xp.getName())){
                            String name = xp.nextText();
                            city.setName(name);
                        }
                        else if ("temp".equals(xp.getName())){
                            String temp = xp.nextText();
                            city.setTemp(temp);
                        }
                        else if ("pm25".equals(xp.getName())){
                            String pm25 = xp.nextText();
                            city.setPm25(pm25);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("city".equals(xp.getName())){
                            cityList.add(city);
                        }
                        break;
                }
                //把指针移动到下一节点，并返回该节点事件类型
                type = xp.next();
            }

            for(City citya: cityList){
                System.out.println(citya.getName().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
