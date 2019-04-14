package vn.edu.tdtu.lab10.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.tdtu.lab10.R;

/**
 * Created by thChung on 4/13/2019.
 */

public class MainActivity extends AppCompatActivity {
    private List<Contact> contactsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex1_activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ContactsAdapter(contactsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // set the adapter
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Contact contact = new Contact("Ho Minh Chung", "0906 246 489");
        contactsList.add(contact);

        Contact contact2 = new Contact("Nguyen Van A", "0906 246 489");
        contactsList.add(contact2);

        Contact contact3 = new Contact("Nguyen Van B", "0906 246 489");
        contactsList.add(contact3);

        mAdapter.notifyDataSetChanged();
    }
}