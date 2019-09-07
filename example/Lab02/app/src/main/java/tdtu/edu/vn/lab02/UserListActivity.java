//package tdtu.edu.vn.lab02;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//import java.util.ArrayList;
//
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class UserListActivity extends AppCompatActivity {
//
//    ArrayList<Contact> contacts;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        // ...
//        // Lookup the recyclerview in activity layout
//        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
//
//        // Initialize contacts
//        contacts = Contact.createContactsList(20);
//        // Create adapter passing in the sample user data
//        ContactsAdapter adapter = new ContactsAdapter(contacts);
//        // Attach the adapter to the recyclerview to populate items
//        rvContacts.setAdapter(adapter);
//        // Set layout manager to position the items
//        rvContacts.setLayoutManager(new LinearLayoutManager(this));
//        // That's all!
//    }
//}