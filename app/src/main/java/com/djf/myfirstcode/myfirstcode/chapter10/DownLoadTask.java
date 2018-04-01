package com.djf.myfirstcode.myfirstcode.chapter10;

import android.os.AsyncTask;

/**
 * Created by Sky000 on 2018/4/1.
 */

public class DownLoadTask extends AsyncTask<Void ,Integer ,Boolean> {
    //开始执行doInBackground之前调用
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    //在调用doInBackground之后调用，（Boolean boolean）的传入参数与AsyncTask的第三个参数一致，由doInbackground执行完成之后返回。
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
    //当在后台线程 doInBackground 中调用publishProgress方法后会调用此方法，传入参数与AsyncTask的第二个参数一致
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Boolean aBoolean) {
        super.onCancelled(aBoolean);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
    //在后台线程中调用，传入参数与AsyncTask的第一个参数一致
    @Override
    protected Boolean doInBackground(Void... params) {
        return null;
    }
}

//new DownLoadTask().execute();执行方法
