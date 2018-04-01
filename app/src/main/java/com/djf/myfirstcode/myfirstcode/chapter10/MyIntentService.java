package com.djf.myfirstcode.myfirstcode.chapter10;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Sky000 on 2018/4/1.
 */

public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"Thread id is in oncreate "+ Thread.currentThread().getId());
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override//在子线程中执行
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG,"Thread id is in onHandleIntent "+ Thread.currentThread().getId());
    }
}
