package me.imli.broadcastreceiver.ordered;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Em on 2017/11/12.
 */

public class FirstReceiver extends BroadcastReceiver {

    private static final String TAG = "OrderedBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Log.e(TAG, "FirstReceiver: " + msg);

        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "@FirstReceiver");
        setResultExtras(bundle);
    }

}
