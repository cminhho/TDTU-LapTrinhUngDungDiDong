package com.example.admin.lab09.exercise03.exercise02;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Admin on 4/6/2019.
 */

public class MyIntentService extends IntentService {
    public static volatile boolean shouldContinue = true;
    private static final String TAG = MyIntentService.class.getName();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service onStartCommand " + startId);
        return Service.START_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent arg0) {
        Log.i(TAG, "Stop service!!!");
        // check the condition
        if (shouldContinue == false) {
            stopSelf();
            return;
        }

        // continue doing something
        AsyncTask task = new MyAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 1);

        // check the condition
        if (shouldContinue == false) {
            stopSelf();
            return;
        }
    }

    public MyIntentService() {
        super("MyIntentService");
    }
}
