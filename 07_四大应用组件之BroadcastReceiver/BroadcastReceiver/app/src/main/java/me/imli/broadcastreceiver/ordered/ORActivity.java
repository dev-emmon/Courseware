package me.imli.broadcastreceiver.ordered;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.imli.broadcastreceiver.R;
import me.imli.broadcastreceiver.br.MyBroadcastReceiver;

/**
 * Created by Em on 2017/11/12.
 */

public class ORActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_receiver_activity);
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(v);
            }
        });
    }

    public void send(View view) {
        Intent intent = new Intent("android.intent.action.MY_BROADCAST");
        intent.putExtra("msg", "hello receiver.");
        sendOrderedBroadcast(intent, "imli.permission.MY_BROADCAST_PERMISSION");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        //实例化BroadcastReceiver子类 &  IntentFilter
//        registerReceiver(new FirstReceiver(), new IntentFilter());
//        registerReceiver(new SecondReceiver(), new IntentFilter());
//        registerReceiver(new SecondReceiver(), new IntentFilter());
    }
}
