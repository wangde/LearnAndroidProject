package com.hlju.wangde.day03_showdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by XiaoDe on 2017/6/3 11:03.
 *
 * @author XiaoDe.
 *         Project Name is LearnAndroidProject.
 */

public class DbOperate {

    private MyOpenHelper oh;
    private SQLiteDatabase db ;

    protected DbOperate(Context context){
        oh = new MyOpenHelper(context, "people.db", null, 1);
        db = oh.getWritableDatabase();
    }
    public void insertApp(String name,String phone,int salary){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("salary",salary);
        long l = db.insert("person",null,values);
        System.out.println(l);
    }
    public void deleteApi(){
        int i = db.delete("person","_id = ?",new String[]{"1"});
        System.out.println(i);
    }
    public void update(){
        ContentValues values = new ContentValues();
        values.put("name","李四");
        int i =  db.update("person",values,"_id = ?",new String[]{"2"});
        System.out.println(i);
    }
    public Cursor select(){
        //arg1:查询字段
        //arg2:查询的where条件
        //arg3:where条件的站位符
        Cursor cursor = db.query("person",null,null,null,null,null,null);
//        while (cursor.moveToNext()){
//            String name = cursor.getString(1);
//            String phone = cursor.getString(2);
//            int salary = cursor.getInt(3);
//            System.out.println(name+";"+phone+";"+salary);
//        }
        return cursor;

    }
    public void transaction(){
        try {
            //开启事物
            db.beginTransaction();
            ContentValues values = new ContentValues();
            values.put("salary", 155555);
            db.update("person", values, "name=?", new String[]{"张三"});
            //清空values数据
            values.clear();
            values.put("salary", 166655);
            db.update("person", values, "name=?", new String[]{"李四"});
            //设置事物执行成功，提交时如果这行代码没执行则回滚
            db.setTransactionSuccessful();
        }finally {
            //关闭事务，提交数据
            db.endTransaction();
        }
    }
}
