package com.djf.myfirstcode.myfirstcode.chapter10;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.djf.myfirstcode.myfirstcode.R;

public class MainActivity extends Activity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private Button stop_Button;
    private Button start_Button;
    private Button bind_Service;
    private Button unBind_Service;
    private Button start_intent_service;
    private MyService.DownLoadBinder mbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Thread id is in oncreate "+ Thread.currentThread().getId());
        setContentView(R.layout.activity_main);
        stop_Button = findViewById(R.id.stop);
        start_Button = findViewById(R.id.start);
        bind_Service = findViewById(R.id.bind);
        unBind_Service = findViewById(R.id.unbind);
        start_intent_service = findViewById(R.id.bind_intent_service);
        stop_Button.setOnClickListener(this);
        start_Button.setOnClickListener(this);
        bind_Service.setOnClickListener(this);
        unBind_Service.setOnClickListener(this);
        start_intent_service.setOnClickListener(this);
    }

    private ServiceConnection myServiceConnection  = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG,"onServiceConnected"+ name.toString());
            mbinder = (MyService.DownLoadBinder)service;
            mbinder.getProgress();
            mbinder.startProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG,"onServiceDisconnected"+ name.toString());
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                Intent start_Intent =  new Intent(this, MyService.class);
                startService(start_Intent);
                break;
            case R.id.stop:
                Intent stop_Intent = new Intent(this,MyService.class);
                stopService(stop_Intent);
                break;
            case R.id.bind:
                Intent bind_Intent  = new Intent(this,MyService.class);
                bindService(bind_Intent,myServiceConnection,BIND_AUTO_CREATE);//绑定服务
                break;
            case R.id.unbind:
                unbindService(myServiceConnection);
                break;
            case R.id.bind_intent_service:
                Intent intent = new Intent(this,MyIntentService.class);
                startService(intent);
                break;
        }
    }
}
