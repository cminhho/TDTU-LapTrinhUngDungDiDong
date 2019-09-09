package vn.edu.tdtu.exam.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.exam.R;

public class SignUpActivity extends AppCompatActivity {
  private Button btnSignUp;
  private EditText edtUsername, edtPassword, edtConfirmPassword;
  private TextView txtUsernameError, txtPwdError, txtConfirmPwdError;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);

    // lookup views
    edtUsername = findViewById(R.id.activity_sign_up_edt_username);
    edtPassword = findViewById(R.id.activity_sign_up_edt_pwd);
    edtConfirmPassword = findViewById(R.id.activity_sign_up_edt_confirm_password);
    btnSignUp = findViewById(R.id.activity_sign_up_btn_login);
    txtUsernameError = findViewById(R.id.activity_sign_up_txt_username_error);
    txtPwdError = findViewById(R.id.activity_sign_up_txt_pwd_error);
    txtConfirmPwdError = findViewById(R.id.activity_sign_up_txt_confirm_password_error);

    // event handlers
    btnSignUp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        boolean isValidSingUpForm = true;
        resetErrorMessage();
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String confirmPassword = edtConfirmPassword.getText().toString();

        if (username.isEmpty()) {
          txtUsernameError.setVisibility(View.VISIBLE);
          txtUsernameError.setText("Username is required");
          isValidSingUpForm = false;
        } else if (username.length() < 5) {
          txtUsernameError.setVisibility(View.VISIBLE);
          txtUsernameError.setText("Username field must be at least 5 characters");
          isValidSingUpForm = false;
        }

        if (password.isEmpty()) {
          txtPwdError.setVisibility(View.VISIBLE);
          txtPwdError.setText("Password is required");
          isValidSingUpForm = false;
        } else if (password.length() < 5) {
          txtPwdError.setVisibility(View.VISIBLE);
          txtPwdError.setText("Password field must be at least 5 characters");
          isValidSingUpForm = false;
        }

        if (confirmPassword.isEmpty()) {
          txtConfirmPwdError.setVisibility(View.VISIBLE);
          txtConfirmPwdError.setText("Confirm Password is required");
          isValidSingUpForm = false;
        } else if (!confirmPassword.equals(password)) {
          txtConfirmPwdError.setVisibility(View.VISIBLE);
          txtConfirmPwdError.setText("Password and Confirm Password does not match");
          isValidSingUpForm = false;
        }

        if(isValidSingUpForm){
          openWelcomeActivity();
        }

      }
    });
  }

  private void resetErrorMessage() {
    txtUsernameError.setVisibility(View.INVISIBLE);
    txtPwdError.setVisibility(View.INVISIBLE);
    txtConfirmPwdError.setVisibility(View.INVISIBLE);
  }

  private void openWelcomeActivity() {
    Intent intent = new Intent(this, WelcomeActivity.class);
    startActivityForResult(intent, 200);
  }
}
