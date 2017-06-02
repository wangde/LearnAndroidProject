package com.hlju.wangde.day03_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.mock.MockContext;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by XiaoDe on 2017/6/2 20:50.
 * @param
 * @author XiaoDe
 * Project Name LearnAndroidProject
 */
public class MyOpenHelperTest {

   MyOpenHelperTest(){
        Context context = new MockContext();
        MyOpenHelper oh = new MyOpenHelper(context,"people.db",null,1);
        //如果数据库不存在先创建再打开，如果存在则直接打开
        SQLiteDatabase db = oh.getWritableDatabase();

    }
    @Test
    public void onCreate() throws Exception {

    }

    @Test
    public void onUpgrade() throws Exception {

    }

}