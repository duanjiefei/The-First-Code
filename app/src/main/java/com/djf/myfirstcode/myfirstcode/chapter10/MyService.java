package com.djf.myfirstcode.myfirstcode.chapter10;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.IntDef;
import android.util.Log;

import com.djf.myfirstcode.myfirstcode.R;

public class MyService extends Service {
    private static final String TAG = "MyService";
    private DownLoadBinder mBinder = new DownLoadBinder();

    public MyService() {
    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
    //仅在服务第一次创建的时候调用
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"MyService onCreate");
        //创建前台服务
        Intent  intent = new Intent(this,MainActivity.class);
        PendingIntent pi  = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new Notification.Builder(this).setContentTitle("this is contenttittle")
                .setContentText("this is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(0,notification);
    }
    //在服务每次启动时都会调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"MyService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
    //在服务销毁时被调用，用来销毁一些需要关闭的资源
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"MyService onDestroy");
    }

    class DownLoadBinder extends Binder{
        public  void startProgress(){
            Log.d(TAG,"startProgress");
        }

        public  int getProgress(){
            Log.d(TAG,"getProgress");
            return 0;
        }
    }
}
