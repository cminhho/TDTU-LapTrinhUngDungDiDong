package com.example.admin.vn.lab02;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.vn.R;

/**
 * Created by thChung on 3/30/2019.
 */

public class Sender extends Activity implements OnClickListener {

    MyReceiver myReceiver;
    IntentFilter intentFilter;
    EditText etReceivedBroadcast;
    Button btnSendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab02);

        etReceivedBroadcast = (EditText) findViewById(R.id.etReceivedBroadcast);
        btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);

        btnSendBroadcast.setOnClickListener(this);

        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter("com.example.admin.vn.MY_NOTIFICATION");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter);
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.admin.vn.MY_NOTIFICATION");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        String msg = etReceivedBroadcast.getText().toString().trim();
        intent.putExtra("msg", msg);
        sendBroadcast(intent);
    }

}