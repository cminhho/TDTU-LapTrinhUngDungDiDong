package com.example.admin.lab09.exercise03;

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
    protected void onHandleIntent(Intent intent) {
        String taskName = intent.getStringExtra("TASK_NAME");
        int i = 0;
        while (i <= 100) {
            try {
                Thread.sleep(1000);
                i++;
                Log.i(TAG, taskName + ": " + i);
            } catch (Exception e) {
            }
        }
    }

    public MyIntentService() {
        super("MyIntentService");
    }
}