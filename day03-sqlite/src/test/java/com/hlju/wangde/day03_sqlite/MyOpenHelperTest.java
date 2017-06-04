package com.hlju.wangde.day03_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.mock.MockContext;

import org.junit.Test;

/**
 * Created by XiaoDe on 2017/6/2 20:50.
 *
 * @param
 * @author XiaoDe
 *         Project Name LearnAndroidProject
 */
public class MyOpenHelperTest {

    public MyOpenHelperTest() {
        Context context = new MockContext();
        MyOpenHelper oh = new MyOpenHelper(context, "people.db", null, 1);
        //如果数据库不存在先创建再打开，如果存在则直接打开
        SQLiteDatabase db = oh.getWritableDatabase();

    }

    @Test
    public void onCreate(SQLiteDatabase db) throws Exception {
        System.out.println("数据库创建");
        db.execSQL("create table person (_id integer primary key autoincrement,name char(10),phone " +
                "char(20),salary integer(10))");
    }

    @Test
    public void onUpgrade() throws Exception {

    }


    public void insert() {
        Context context = new MockContext();
        MyOpenHelper oh = new MyOpenHelper(context, "people.db", null, 1);
        SQLiteDatabase db = oh.getWritableDatabase();
        db.execSQL("insert into person (name,phone,salary) values(?,?,?)", new Object[]{"张三", "123456", "123400"});
    }

}