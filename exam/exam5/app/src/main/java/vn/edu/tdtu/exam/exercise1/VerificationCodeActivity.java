package vn.edu.tdtu.exam.exercise1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.admin.exam.R;

public class VerificationCodeActivity extends AppCompatActivity {
  private Button btnVerify;
  private EditText edtCode;
  private TextView txtMessage;

  private String verifiedEmail;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verification_code);

    // lookup views
    edtCode = findViewById(R.id.activity_verification_code_edt_code);
    btnVerify = findViewById(R.id.activity_verification_code_btn_submit);
    txtMessage = findViewById(R.id.activity_verification_code_txt_message);

    verifiedEmail = getIntent().getStringExtra(VerificationActivity.EMAIL_ADDRESS_INTENT);

    txtMessage.setText(verifiedEmail);

    // event handlers
    btnVerify.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String verificationCode = edtCode.getText().toString();

        if (verificationCode.length() == 4) {
          Toast.makeText(VerificationCodeActivity.this, "Verification Complete!", Toast.LENGTH_LONG).show();
        } else {
          Toast.makeText(VerificationCodeActivity.this, "Incorrect verification code!", Toast.LENGTH_LONG).show();
        }
      }
    });
  }
}
