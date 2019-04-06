package com.example.admin.lab09.exercise02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.lab09.R;

public class Exercise02 extends AppCompatActivity {
    public static final String TASK_NAME = "TASK_NAME";
    Intent intent;
    private TextView txtProgress;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_02);

        Button btnCreateSyncTask = (Button) findViewById(R.id.btnCreateSyncTask);
        Button btnStopSyncTask = (Button) findViewById(R.id.btnStopSyncTask);
        txtProgress = (TextView) findViewById(R.id.txtProgress);

        btnCreateSyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSyncTasks(v);
            }
        });

        btnStopSyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(v);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(MyService.NOTIFICATION));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void doSyncTasks(View view)
    {
        intent = new Intent(this, MyService.class);
        intent.putExtra(TASK_NAME, "TASK_NAME/" + i++);
        startService(intent);
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String taskName = bundle.getString(MyService.TASK_NAME);
                String resultCode = bundle.getString(MyService.RESULT);
                String progressValue = bundle.getString(MyService.PROGRESS_VALUE);
                if (resultCode.equals("DOWNLOADING")) {
                    Toast.makeText(Exercise02.this,
                            "Downloading: ", Toast.LENGTH_LONG).show();
                    txtProgress.setText("Progress : " + progressValue);
                } else {
                    Toast.makeText(Exercise02.this, "Downloaded",
                            Toast.LENGTH_LONG).show();
                    txtProgress.setText("Downloaded!");
                }
            }
        }
    };
}