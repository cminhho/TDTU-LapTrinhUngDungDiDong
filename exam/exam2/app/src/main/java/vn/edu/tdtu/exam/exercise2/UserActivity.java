package vn.edu.tdtu.exam.exercise2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.exam.R;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

  private List<User> users = new ArrayList<>();
  private RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_users);

    // Lookup the recyclerview in activity_users_rv_movies layout
    recyclerView = findViewById(R.id.activity_users_rv_movies);

    // Create adapter passing in the sample user data
    UsersAdapter mAdapter = new UsersAdapter(users);
    // Attach the adapter to the recyclerview to populate items
    recyclerView.setAdapter(mAdapter);
    // Set layout manager to position the items
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    // Initialize users
    populateUserDetails();
    mAdapter.notifyDataSetChanged();
  }

  private void populateUserDetails() {
    for (int i = 0; i < 20; i++) {
      users.add(new User("User " + i, "user" + i + "@tdtu.edu.vn"));
    }
  }

}