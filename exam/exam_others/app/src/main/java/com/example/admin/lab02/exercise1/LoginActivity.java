package com.example.admin.lab02.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.lab02.R;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtUsername;
    private EditText edtPassword;

    public static final String USER_NAME_INTENT = "USER_NAME";
    public static final int SUCCESS_CODE = 200;
    private TextView txtErrorMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        // mapping views
        edtUsername = findViewById(R.id.activity_login_edt_username);
        edtPassword = findViewById(R.id.activity_login_edt_password);
        btnLogin = findViewById(R.id.activity_login_btn_login);
        txtErrorMessage = findViewById(R.id.activity_login_txt_error_message);

        // even handlers
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(username.equals(password)){
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
