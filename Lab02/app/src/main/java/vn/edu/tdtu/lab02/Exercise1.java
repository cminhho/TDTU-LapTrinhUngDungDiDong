package vn.edu.tdtu.lab02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Exercise1 extends AppCompatActivity {
    private EditText mPassword;
    private EditText mUsername;
    private CheckBox mRemeberPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        // Setup UI
        mPassword = (EditText) findViewById(R.id.password);
        mUsername = (EditText) findViewById(R.id.username);
        mRemeberPassword = (CheckBox) findViewById(R.id.cbRememberPassword);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                boolean isRemeberPassword = mRemeberPassword.isChecked();

                // Xuất ra thông báo bằng Toast cho người dùng nếu username hoặc password rỗng
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Exercise1.this, "Username hoặc password rỗng", Toast.LENGTH_LONG).show();
                }

                // Nếu mật khẩu và tên đăng nhập giống nhau thì xuất ra thông báo đăng nhập thành công, ngược lại thì thông báo đăng nhập thất bại.
                if(username.equals(password)){
                    Toast.makeText(Exercise1.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Exercise1.this, "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
                }

                // Nếu người dùng chọn “Remember Password” thì xuất thêm thông báo “Mật khẩu đã được lưu”.
                if(isRemeberPassword){
                    Toast.makeText(Exercise1.this, "Mật khẩu đã được lưu!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
