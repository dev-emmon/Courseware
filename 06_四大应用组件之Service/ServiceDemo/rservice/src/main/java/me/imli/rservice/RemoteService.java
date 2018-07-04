package me.imli.rservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Em on 2017/11/12.
 */

public class RemoteService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iMsgAidlInterface;
    }

    private IMsgAidlInterface.Stub iMsgAidlInterface = new IMsgAidlInterface.Stub() {
        @Override
        public int sum(int x, int y) throws RemoteException {
            return x + y;
        }
    };


}
