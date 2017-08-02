package com.hlju.wangde.day10_mycontentprovide;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.hlju.wangde.day10_mycontentprovide.db.MyOpenHelper;

public class PersonProvide extends ContentProvider {
    private SQLiteDatabase db;
    //创建URI匹配器
    UriMatcher um = new UriMatcher(UriMatcher.NO_MATCH);

    {
        um.addURI("com.hlju.wangde.people", "person", 1);
        um.addURI("com.hlju.wangde.people", "handsome", 2);
        um.addURI("com.hlju.wangde.people", "handsome/#", 3);//#代表后边匹配数字
    }

    public PersonProvide() {
    }


    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //内容提供者创建时调用
    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        MyOpenHelper oh = new MyOpenHelper(getContext());
        db = oh.getWritableDatabase();
        return false;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        if (um.match(uri) == 1) {
            db.insert("person", null, values);
            //arg0:通知发到哪个URI,注册在这个uri上的内容观察者都可以收到
            getContext().getContentResolver().notifyChange(uri, null);
        } else if (um.match(uri) == 2) {
            db.insert("handsome", null, values);
            getContext().getContentResolver().notifyChange(uri, null);
        } else {
            throw new IllegalArgumentException("uri错误");
        }
        return uri;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;
        if (um.match(uri) == 1) {
            cursor = db.query("person", projection, selection, selectionArgs, null, null, sortOrder, null);
        } else if (um.match(uri) == 2) {
            cursor = db.query("handsome", projection, selection, selectionArgs, null, null, sortOrder, null);
        } else if (um.match(uri) == 3) {
            //取出URI末尾的数字
            long id = ContentUris.parseId(uri);
            cursor = db.query("handsome", projection, "_id = ?", new String[]{"" + id}, null, null, sortOrder, null);
        } else {
            throw new IllegalArgumentException("uri错误");
        }

        return cursor;
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        int i = -1;
        if (um.match(uri) == 1) {
            i = db.delete("person", selection, selectionArgs);
        } else if (um.match(uri) == 2) {
            i = db.delete("handsome", selection, selectionArgs);
        }
        return i;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int i = -1;
        if (um.match(uri) == 1) {
            i = db.update("person", values, selection, selectionArgs);
        } else if (um.match(uri) == 2) {
            i = db.update("handsome", values, selection, selectionArgs);
        }
        return i;
    }


}
