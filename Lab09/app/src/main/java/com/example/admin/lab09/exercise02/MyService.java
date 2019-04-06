package com.example.admin.lab09.exercise02;

/**
 * Created by Admin on 4/6/2019.
 */

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = MyService.class.getName();

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand " + startId);

        AsyncTask task = new MyAsyncTask().executeOnExecutor(
                AsyncTask.THREAD_POOL_EXECUTOR, startId);
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service onDestroy");
    }
}