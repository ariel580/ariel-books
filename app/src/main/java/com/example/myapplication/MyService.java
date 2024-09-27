package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}