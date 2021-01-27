package com.example.android;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import java.util.logging.Logger;

public class MyService extends JobIntentService {

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

    public static final int JOB_ID = 1;

    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, MyService.class, JOB_ID, work);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {

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
