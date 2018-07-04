package me.imli.broadcastreceiver.br;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.imli.broadcastreceiver.R;

/**
 * Created by Em on 2017/11/12.
 */

public class BRActivity extends AppCompatActivity {


    MyBroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume(){
        super.onResume();

        //实例化BroadcastReceiver子类 &  IntentFilter
        mBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();


//        //设置接收广播的类型
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        //调用Context的registerReceiver（）方法进行动态注册
        registerReceiver(mBroadcastReceiver, intentFilter);
    }


    //注册广播后，要在相应位置记得销毁广播
//即在onPause() 中unregisterReceiver(mBroadcastReceiver)
//当此Activity实例化时，会动态将MyBroadcastReceiver注册到系统中
//当此Activity销毁时，动态注册的MyBroadcastReceiver将不再接收到相应的广播。
    @Override
    protected void onPause() {
        super.onPause();
        //销毁在onResume()方法中的广播
//        unregisterReceiver(mBroadcastReceiver);
    }

}
