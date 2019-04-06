package com.example.admin.lab09.exercise02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.lab09.R;

public class Exercise02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);

        Button btnSyncTask = (Button) findViewById(R.id.btnSyncTask);
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);

        btnSyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSyncTasks(v);
            }
        });
    }

    public void doSyncTasks(View view)
    {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
}