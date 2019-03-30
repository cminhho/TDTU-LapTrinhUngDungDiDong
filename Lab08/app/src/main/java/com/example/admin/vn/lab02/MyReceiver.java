package com.example.admin.vn.lab02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by thChung on 3/30/2019.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.example.admin.vn.MY_NOTIFICATION")){
            String intentData = intent.getStringExtra("msg");
            Toast.makeText(context, "Received the Intent's message: " + intentData, Toast.LENGTH_LONG).show();
        }
    }

}