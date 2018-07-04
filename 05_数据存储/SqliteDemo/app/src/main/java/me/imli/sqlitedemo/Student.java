package me.imli.sqlitedemo;

/**
 * Created by Em on 2017/11/22.
 */

public class Student {

    public int sid;

    public String name;

    public int age;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
