package com.omen.contentwriter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/7/27.
 */
public class MyProvider extends ContentProvider {

    public static final Uri URI = Uri.parse("content://com.omen.contentwriter/tab");
    SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        database = getContext().openOrCreateDatabase("mycp.db3", Context.MODE_PRIVATE, null);
        database.execSQL("create table tab(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL)");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Cursor cursor = database.query("tab", null, null, null, null, null, null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        /*关于参数的解释：http://www.educity.cn/wenda/586383.html*/
        /*第二个参数的作用主要是防止产生这样的insert语句：*/
        /*insert into tableName()values()*/
        /*database.insert("tab", "_id", contentValues);*/
        database.insert("tab", null, contentValues);
        /*不要关闭数据库，否则另外一个APP不能访问*/
        /*database.close();*/
        return uri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
