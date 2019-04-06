package com.example.admin.lab09.exercise03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.lab09.R;

public class Exercise03 extends AppCompatActivity {
    Intent intent;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_03);

        Button btnCreateSyncTask = (Button) findViewById(R.id.btnCreateSyncTask);
        Button btnStopSyncTask = (Button) findViewById(R.id.btnStopSyncTask);

        btnCreateSyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSyncTasks(v);
                MyIntentService.shouldContinue = true;
            }
        });

        btnStopSyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyIntentService.shouldContinue = false;
                stopService(intent);
            }
        });
    }

    public void doSyncTasks(View view) {
        intent = new Intent(this, MyIntentService.class);
        intent.putExtra("TASK_NAME", "TASK_NAME/" + i++);
        startService(intent);
    }
}