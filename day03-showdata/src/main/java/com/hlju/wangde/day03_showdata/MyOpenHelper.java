package com.hlju.wangde.day03_showdata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by XiaoDe on 2017/6/2.
 *
 * @author xiaode
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //arg1:数据库文件名
        //arg2:游标工厂，游标等同于结果集，传null使用默认工厂
        //arg3:版本，不能小于1，用于升级
        super(context, name, factory, version);
    }

    //创建数据库时系统调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("数据库创建");
        db.execSQL("create table person (_id integer primary key autoincrement,name char(10),phone " +
                "char(20),salary integer(10))");

    }

    //升级数据库时调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("数据库升级");

    }

}
