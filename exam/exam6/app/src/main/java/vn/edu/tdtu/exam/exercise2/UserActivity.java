package vn.edu.tdtu.exam.exercise2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.exam.R;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

  private List<User> users = new ArrayList<>();
  private RecyclerView recyclerView;
  private Button btnCreate;
  private UsersAdapter mAdapter;
  private Button btnRemove;
  private TextView txtTotalUsers;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_users);

    // Lookup the recyclerview in activity_users_rv_movies layout
    recyclerView = findViewById(R.id.activity_users_rv_users);
    btnCreate = findViewById(R.id.activity_users_btn_create);
    btnRemove = findViewById(R.id.activity_users_btn_remove);
    txtTotalUsers = findViewById(R.id.activity_users_txt_total_users);

    // Create adapter passing in the sample user data
    mAdapter = new UsersAdapter(users);
    // Attach the adapter to the recyclerview to populate items
    recyclerView.setAdapter(mAdapter);
    // Set layout manager to position the items
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    // Initialize users
    setTotalUsers();
    mAdapter.notifyDataSetChanged();

    btnCreate.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        populateUserDetails(5);
        setTotalUsers();
        mAdapter.notifyDataSetChanged();
      }
    });

    btnRemove.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        if(users.isEmpty()) {
          Toast.makeText(UserActivity.this, "List of users is empty", Toast.LENGTH_LONG).show();
        } else {
          removeUsers(5);
        }
        setTotalUsers();
        mAdapter.notifyDataSetChanged();
      }
    });
  }

  private void setTotalUsers() {
    int numberOfUsers = users.size();
    txtTotalUsers.setText("Total users: " + numberOfUsers);
  }

  private void removeUsers(int numberOfUsers) {
    for (int i = 0; i < numberOfUsers; i++) {
      users.remove(users.size() - 1);
    }
  }

  private void populateUserDetails(int numberOfUsers) {
    int from = users.size() + 1;
    int to = from + numberOfUsers;
    for (int i = from; i < to; i++) {
      users.add(new User("User " + i, "user" + i + "@tdtu.edu.vn"));
    }
  }

}