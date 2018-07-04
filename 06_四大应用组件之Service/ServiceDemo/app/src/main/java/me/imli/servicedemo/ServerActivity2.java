package me.imli.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telecom.ConnectionService;
import android.view.View;

/**
 * Created by Em on 2017/11/12.
 */

public class ServerActivity2 extends AppCompatActivity implements View.OnClickListener {


    private MyServer2.MyBinder myBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server2);
        findViewById(R.id.start_service).setOnClickListener(this);
        findViewById(R.id.stop_service).setOnClickListener(this);
        findViewById(R.id.bind_service).setOnClickListener(this);
        findViewById(R.id.unbind_service).setOnClickListener(this);

    }

    /**
     *
     */
    private ServiceConnection serviceConnection = new ServiceConnection () {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyServer2.MyBinder) service;
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.start_service:
                Intent startIntent = new Intent(this, MyServer2.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent = new Intent(this, MyServer2.class);
                stopService(stopIntent);
                break;
            case R.id.bind_service:
                Intent bindIntent = new Intent(this, MyServer2.class);
                bindService(bindIntent, serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(serviceConnection);
                break;
        }
    }
}
