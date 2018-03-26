package com.djf.myfirstcode.myfirstcode.chapter10;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.djf.myfirstcode.myfirstcode.R;

/**
 * Created by Sky000 on 2018/3/25.
 */

public class ThreadTestActvity extends Activity implements View.OnClickListener{
    private TextView textView;
    private Button change_text;
    private static final int UPDATE_TEXT = 1;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE_TEXT:
                    String text = (String) msg.obj;
                    textView.setText(text);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_test);
        textView = findViewById(R.id.text_view);
        change_text = findViewById(R.id.change_text);
        change_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = new Message();
                        msg.what = UPDATE_TEXT;
                        msg.obj = "Nice to Meet you";
                        handler.sendMessage(msg);
                        //textView.setText("Nice to Meet You");
                    }
                }).start();
                //textView.setText("Nice to Meet You");
                break;
        }
    }
}
