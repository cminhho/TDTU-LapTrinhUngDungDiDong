package vn.edu.tdtu.example3.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import vn.edu.tdtu.example3.home.HomeActivity;
import vn.edu.tdtu.example3.R;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtUsername;
    private EditText edtPassword;
    private CheckBox cbRememberPassword;

    public static final String USER_NAME_INTENT = "USER_NAME";
    public static final int SUCCESS_CODE = 200;
    private TextView txtErrorMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // mapping views
        edtUsername = findViewById(R.id.activity_login_edt_username);
        edtPassword = findViewById(R.id.activity_login_edt_password);
        btnLogin = findViewById(R.id.activity_login_btn_login);
        cbRememberPassword = findViewById(R.id.activity_login_cb_remember_password);
        txtErrorMessage = findViewById(R.id.activity_login_txt_error_message);

        // even handlers
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                boolean isRememberPasswordChecked = cbRememberPassword.isChecked();

                if(username.equals(password)){
                    openHomeActivity();
                } else {
                    txtErrorMessage.setText("đăng nhập thất bại");
                }

                if(isRememberPasswordChecked) {
                    showToast("Mật khẩu đã được lưu");
                }

            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        String userName = edtUsername.getText().toString();
        intent.putExtra(USER_NAME_INTENT, userName);
        startActivityForResult(intent, SUCCESS_CODE);
    }
}
