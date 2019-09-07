//package com.example.admin.lab02.contact;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//
//import com.example.admin.lab02.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ContactActivity extends AppCompatActivity {
//
//    List<User> users = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_contacts);
//        // Lookup the recyclerview in activity layout
//        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
//
//        // Initialize users
//        users = User.createContactsList(20);
//        // Create adapter passing in the sample user data
//        ContactsAdapter adapter = new ContactsAdapter(users);
//        // Attach the adapter to the recyclerview to populate items
//        rvContacts.setAdapter(adapter);
//        // Set layout manager to position the items
//        rvContacts.setLayoutManager(new LinearLayoutManager(this));
//    }
//}
