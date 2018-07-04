package me.imli.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Em on 2017/11/22.
 */

public class MySqliteOpenHepler extends SQLiteOpenHelper {

    public final static String DB_NAME = "demo.sqlite";
    public final static int DB_VERSION = 1;

    // 表名称
    public final static String TABLE_STUDENT = "student";

    public MySqliteOpenHepler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建学生表
        db.execSQL("create table "+ TABLE_STUDENT + " (sid integer primary key, name varchar(20), age integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
