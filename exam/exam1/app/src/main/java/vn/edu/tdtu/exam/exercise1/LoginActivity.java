package vn.edu.tdtu.exam.exercise1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.exam.R;

public class LoginActivity extends AppCompatActivity {
  public static final String USER_NAME_INTENT = "USER_NAME";
  public static final int SUCCESS_CODE = 200;

  private Button btnLogin;
  private EditText edtUsername;
  private EditText edtPassword;
  private TextView txtErrorMessage;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    // lookup views
    edtUsername = findViewById(R.id.activity_login_edt_username);
    edtPassword = findViewById(R.id.activity_login_edt_password);
    btnLogin = findViewById(R.id.activity_login_btn_login);
    txtErrorMessage = findViewById(R.id.activity_login_txt_error_message);

    // event handlers
    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.equals(password)) {
          openHomeActivity();
        } else {
          txtErrorMessage.setText("Incorrect username or password");
        }
      }
    });
  }

  private void openHomeActivity() {
    Intent intent = new Intent(this, HomeActivity.class);
    String userName = edtUsername.getText().toString();
    intent.putExtra(USER_NAME_INTENT, userName);
    startActivityForResult(intent, SUCCESS_CODE);
  }
}
