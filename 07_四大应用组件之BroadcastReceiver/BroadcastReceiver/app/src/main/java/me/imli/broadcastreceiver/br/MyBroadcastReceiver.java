package me.imli.broadcastreceiver.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Em on 2017/11/12.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    private final String TAG = "MyBroadcastReceiver";

    //接收到广播后自动调用该方法
    @Override
    public void onReceive(Context context, Intent intent) {
        //写入接收广播后的操作
        Log.d(TAG, "==============================================");
        Log.d(TAG, "网络连接 状态改变");
        Log.d(TAG, intent.toString());
    }
}
