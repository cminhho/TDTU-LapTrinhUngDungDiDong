package com.example.admin.lab09.exercise02;

/**
 * Created by thChung on 4/6/2019.
 */

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public static final String TAG = MyService.class.getName();

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String taskName = intent.getStringExtra(Exercise02.TASK_NAME);
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        int i = 0;
        while (i <= 100) {
            try {
                Thread.sleep(1000);
                i++;
                Log.i(TAG, taskName + ": " + i);
            } catch (Exception e) {
            }
        }
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}