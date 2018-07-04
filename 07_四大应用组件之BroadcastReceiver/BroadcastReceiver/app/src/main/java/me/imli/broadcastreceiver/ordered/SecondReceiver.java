package me.imli.broadcastreceiver.ordered;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Em on 2017/11/12.
 */

public class SecondReceiver extends BroadcastReceiver {

    private static final String TAG = "OrderedBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultExtras(true).getString("msg");
        Log.e(TAG, "SecondReceiver: " + msg);

        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "@SecondReceiver");
        setResultExtras(bundle);
    }

}
