package com.tdt.lab05.exercise1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tdt.lab05.Item;
import com.tdt.lab05.ItemsAdapter;
import com.tdt.lab05.R;

import java.util.ArrayList;

public class Exercise1 extends AppCompatActivity {
    private ListView lvUsers;
    private ArrayList<Item> items;
    private ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_1);

        initView();
        initData();
        handleListViewEvents();
    }

    private void handleListViewEvents() {
        itemsAdapter = new ItemsAdapter(Exercise1.this, items);
        lvUsers.setAdapter(itemsAdapter);
        lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = (Item) parent.getItemAtPosition(position);
                Toast.makeText(Exercise1.this, selectedItem.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        items = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            String itemName = "item " + i;
            Item item = new Item(itemName, true);
            items.add(item);
        }
    }

    private void initView() {
        lvUsers = (ListView) findViewById(R.id.lvUsers);
    }
}
