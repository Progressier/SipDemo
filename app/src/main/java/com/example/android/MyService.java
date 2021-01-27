package com.example.android;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import java.util.logging.Logger;

public class MyService extends Service {

    private static BroadcastReceiver receiver;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("sljdvbskljdgvbs", "start");
        registerScreenOffReceiver();
    }

    @Override
    public void onDestroy() {
        Log.i("sljdvbskljdgvbs", "stop");
        unregisterReceiver(receiver);
        receiver = null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    private void registerScreenOffReceiver() {
        receiver = new IncomingCallReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.SipDemo.INCOMING_CALL");
        registerReceiver(receiver, filter);
    }
}
