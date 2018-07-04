package me.imli.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import me.imli.rservice.IMsgAidlInterface;

/**
 * Created by Em on 2017/11/12.
 */

public class RemoteServiceActivity extends AppCompatActivity {

    public static final String TAG = "MyService";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server3);

        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });
    }

    private IMsgAidlInterface iService;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iService = IMsgAidlInterface.Stub.asInterface(service);
            try {
                final int sum = iService.sum(1 , 2);
                Log.e(TAG, "sum ===>  " + sum);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iService = null;
            Log.e(TAG, "onServiceDisconnected::::::::" + iService);
        }
    };
    private boolean bindService;


    private void startService() {
        final Intent in = new Intent();
        in.setClassName(this, "me.imli.rservice.RemoteService");
        in.setPackage("me.imli.rservice");
        in.setAction("me.imli.rservice.RemoteService");
        bindService = bindService(in, conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (conn != null) {
            unbindService(conn);
        }
    }

}
