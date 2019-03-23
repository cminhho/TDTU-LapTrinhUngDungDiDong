package com.tdt.lab05.exercise3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.tdt.lab05.Item;
import com.tdt.lab05.ItemsAdapter;
import com.tdt.lab05.R;

import java.util.ArrayList;

public class Exercise3 extends AppCompatActivity {
    private GridView gvComputers;
    private ArrayList<Item> items;
    private ComputersAdapter computersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_3);

        initView();
        initData();
        handleEvents();
    }

    private void handleEvents() {
        computersAdapter = new ComputersAdapter(Exercise3.this, items);
        gvComputers.setAdapter(computersAdapter);

        gvComputers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initData() {
        items = new ArrayList<>();
        for (int i = 1; i < 30; i++) {
            String itemName = "PC " + i;
            Item item = new Item(itemName, true);
            items.add(item);
        }
    }

    private void initView() {
        gvComputers = (GridView) findViewById(R.id.gvComputers);
    }
}
