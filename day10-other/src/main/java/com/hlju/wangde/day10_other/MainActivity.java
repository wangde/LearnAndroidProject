package com.hlju.wangde.day10_other;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View view) {
        //获取ContentResolver
        ContentResolver resolver = getContentResolver();
        //访问内容提供者插入数据
        ContentValues values = new ContentValues();
//        values.put("name", "wang");
//        values.put("phone", "12345678");
//        values.put("salary", 155000);
//        resolver.insert(Uri.parse("content://com.hlju.wangde.people/person"), values);
//        values.clear();
//        values.put("name", "lil");
//        values.put("phone", "12349874");
//        values.put("salary", 188880);
//        resolver.insert(Uri.parse("content://com.hlju.wangde.people/person"), values);
//        values.put("name", "wangddddd");
//        values.put("phone", "1234898988");
//        values.put("salary", 18899945);
//        resolver.insert(Uri.parse("content://com.hlju.wangde.people/person"), values);
//        values.clear();
        values.put("name", "lileea");
        values.put("phone", "123654224");
        resolver.insert(Uri.parse("content://com.hlju.wangde.people/handsome"), values);
        values.clear();
        values.put("name", "lileeb");
        values.put("phone", "123654224");
        resolver.insert(Uri.parse("content://com.hlju.wangde.people/handsome"), values);
        values.clear();
        values.put("name", "lileec");
        values.put("phone", "123654224");
        resolver.insert(Uri.parse("content://com.hlju.wangde.people/handsome"), values);
        values.clear();
        values.put("name", "lileed");
        values.put("phone", "123654224");
        resolver.insert(Uri.parse("content://com.hlju.wangde.people/handsome"), values);
    }

    public void delete(View view) {
        ContentResolver resolver = getContentResolver();
        int i = resolver.delete(Uri.parse("content://com.hlju.wangde.people/handsome"), "name = ?", new String[]{"wangddddd"});
        System.out.print(i + "+++++++++++++++++++++++++++++++++");
    }

    public void update(View view) {
        ContentResolver resolver = getContentResolver();
        ContentValues values = new ContentValues();
        values.put("salary", 177777);
        int i = resolver.update(Uri.parse("content://com.hlju.wangde.people/person"), values, "name = ?", new String[]{"wang"});
        System.out.println(i + "-----------------------");
    }

    public void query(View view) {
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(Uri.parse("content://com.hlju.wangde.people/handsome/2"), null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            System.out.println("name" + name + " phone:" + phone);
        }
    }
}
