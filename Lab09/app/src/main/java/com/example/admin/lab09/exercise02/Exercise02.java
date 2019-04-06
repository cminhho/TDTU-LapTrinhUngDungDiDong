package com.example.admin.lab09.exercise02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
}