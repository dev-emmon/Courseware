package me.imli.pushdemo;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Em on 2017/11/23.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
