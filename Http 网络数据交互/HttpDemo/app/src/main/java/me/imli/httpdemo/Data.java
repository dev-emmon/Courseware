package me.imli.httpdemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Em on 2017/11/22.
 */

public class Data {

    public String data;

    public int code;

    @SerializedName("msg")
    public String message;

}
