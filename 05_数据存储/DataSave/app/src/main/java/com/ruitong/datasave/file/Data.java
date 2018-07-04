package com.ruitong.datasave.file;

import java.io.Serializable;

/**
 * Created by Em on 2016/7/14.
 */
public class Data implements Serializable {

    public String data;

    public String code;

    public String info;

    public Data(String d, String c, String i) {
        this.data = d;
        this.code = c;
        this.info = i;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data='" + data + '\'' +
                ", code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
