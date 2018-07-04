package me.imli.broadcastreceiver.ordered;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Em on 2017/11/12.
 */

public class ThirdReceiver extends BroadcastReceiver {

    private static final String TAG = "OrderedBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultExtras(true).getString("msg");
        Log.e(TAG, "ThirdReceiver: " + msg);
    }

}
