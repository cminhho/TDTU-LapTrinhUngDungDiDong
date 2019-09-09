package com.example.admin.lab02.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.lab02.R;
import com.example.admin.lab02.home.HomeActivity;

public class RegisterActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtUsername;
    private EditText edtPassword;

    public static final String USER_NAME_INTENT = "USER_NAME";
    public static final int SUCCESS_CODE = 200;
    private TextView txtErrorMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }
}
