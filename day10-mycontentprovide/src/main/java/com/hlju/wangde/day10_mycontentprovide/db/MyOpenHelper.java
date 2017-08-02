package com.hlju.wangde.day10_mycontentprovide.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by XiaoDe on 2017/6/22 15:08.
 *
 * @author XiaoDe.
 *         Project Name is LearnAndroidProject.
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context) {
        super(context, "people.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person (_id integer primary key autoincrement,name char(10)," +
                "phone char(20),salary integer(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table handsome (_id integer primary key autoincrement,name char(10)," +
                "phone char(20))");

    }
}
