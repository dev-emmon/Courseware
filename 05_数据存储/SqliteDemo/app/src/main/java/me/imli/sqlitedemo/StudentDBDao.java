package me.imli.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Em on 2017/11/22.
 */

public class StudentDBDao {

    private MySqliteOpenHepler dbHepler;

    public StudentDBDao(Context context) {
        dbHepler = new MySqliteOpenHepler(context);
    }

    /**
     * 插入一条数据
     * @param student
     */
    public void insert(Student student) {
        SQLiteDatabase db = dbHepler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("sid", student.sid);
        values.put("name", student.name);
        values.put("age", student.age);
        //nullColumnHack：当values参数为空或者里面没有内容的时候，我们insert是会失败的（底层数据库不允许插入一个空行），
        //为了防止这种情况，我们要在这里指定一个列名，到时候如果发现将要插入的行为空行时，就会将你指定的这个列名的值设为null，
        //然后再向数据库中插入。
        db.insert(MySqliteOpenHepler.TABLE_STUDENT, "sid", values);
    }

    /**
     * 删除一条数据
     * @param id
     */
    public void delete(int id) {
        SQLiteDatabase db = dbHepler.getWritableDatabase();

        db.delete(MySqliteOpenHepler.TABLE_STUDENT, "sid=?", new String[]{ "" + id});
    }


    /**
     * 更新数据
     * @param student
     */
    public void update(Student student) {
        SQLiteDatabase db = dbHepler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("age", student.age);
        values.put("name", student.name);

        db.update(MySqliteOpenHepler.TABLE_STUDENT, values, "sid=?", new String[]{ student.sid + ""});
    }

    /**
     * 查询所有学生信息
     */
    public List<Student> queryAll() {
        SQLiteDatabase db = dbHepler.getReadableDatabase();

        Cursor cursor = db.query(MySqliteOpenHepler.TABLE_STUDENT, null, null, null, null, null, null);

        List<Student> students = new ArrayList<>();

        while (cursor.moveToNext()) {
            Student student = new Student();
            student.sid = cursor.getInt(cursor.getColumnIndex("sid"));
            student.age = cursor.getInt(cursor.getColumnIndex("age"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
        }
        return students;
    }

    /**
     * 根据 id 查询学生信息
     * @param sid
     * @return
     */
    public Student query(int sid) {
        SQLiteDatabase db = dbHepler.getReadableDatabase();
        Cursor cursor = db.query(MySqliteOpenHepler.TABLE_STUDENT, null, "sid=?", new String[]{sid + ""}, null, null, null);
        if (cursor.moveToFirst()) {
            Student student = new Student();
            student.sid = cursor.getInt(cursor.getColumnIndex("sid"));
            student.age = cursor.getInt(cursor.getColumnIndex("age"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            return student;
        } else {
            return null;
        }
    }

}
