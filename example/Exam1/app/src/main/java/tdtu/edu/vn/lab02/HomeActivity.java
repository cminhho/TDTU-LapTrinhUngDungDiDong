package tdtu.edu.vn.lab02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Admin on 9/7/2019.
 */

public class HomeActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtUsername;
    private EditText edtPassword;
    private CheckBox cbRememberPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
}
