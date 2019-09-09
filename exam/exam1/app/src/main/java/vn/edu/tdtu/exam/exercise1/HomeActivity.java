package vn.edu.tdtu.exam.exercise1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.admin.exam.R;

public class HomeActivity extends AppCompatActivity {

  private TextView tvWelcomeMessage;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    tvWelcomeMessage = findViewById(R.id.activity_home_tv_welcome_message);

    String email = getIntent().getStringExtra(LoginActivity.USER_NAME_INTENT);
    tvWelcomeMessage.setText("Successfully logged in, your account is " + email);
  }
}
