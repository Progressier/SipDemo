package com.example.android;

import android.app.Application;
import android.content.Intent;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        Intent service = new Intent(this, MyService.class);
//        startService(service);
        MyService.enqueueWork(this, new Intent());
    }

}
