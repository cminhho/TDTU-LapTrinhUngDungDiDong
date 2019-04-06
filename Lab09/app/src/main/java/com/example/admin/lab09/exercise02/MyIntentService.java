package com.example.admin.lab09.exercise02;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Admin on 4/6/2019.
 */

public class MyIntentService extends IntentService {

    private static final String TAG = MyIntentService.class.getName();

    @Override
    protected void onHandleIntent(Intent arg0) {
        Log.i(TAG, "Intent Service started");
    }

    public MyIntentService() {
        super("MyIntentService");
    }
}