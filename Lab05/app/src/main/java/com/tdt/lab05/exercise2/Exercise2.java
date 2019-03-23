package com.tdt.lab05.exercise2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.tdt.lab05.Item;
import com.tdt.lab05.ItemsAdapter;
import com.tdt.lab05.R;

import java.util.ArrayList;

public class Exercise2 extends AppCompatActivity {
    private EditText edtItemName;
    private Button btnAdd;
    private ListView lvUsers;
    private ArrayList<Item> items;
    private ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_2);

        initView();
        initData();
        handleEvents();
    }

    private void handleEvents() {
        itemsAdapter = new ItemsAdapter(Exercise2.this, items);
        lvUsers.setAdapter(itemsAdapter);
        lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = (Item) parent.getItemAtPosition(position);
                Toast.makeText(Exercise2.this, selectedItem.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = edtItemName.getText().toString();
                Item newItem = new Item(itemName);
                items.add(newItem);
                itemsAdapter.notifyDataSetChanged();
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
        edtItemName = (EditText) findViewById(R.id.edtItemName);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lvUsers = (ListView) findViewById(R.id.lvUsers);
    }
}
