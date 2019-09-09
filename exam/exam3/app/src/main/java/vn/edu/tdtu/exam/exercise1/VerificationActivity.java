package vn.edu.tdtu.exam.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.exam.R;

public class VerificationActivity extends AppCompatActivity {
  public static final String PHONE_NUMBER_INTENT = "PHONE_NUMBER";
  public static final int SUCCESS_CODE = 200;

  private Button btnVerify;
  private EditText edtPhoneNumber;
  private TextView txPhoneErrMessage;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verification);

    // lookup views
    edtPhoneNumber = findViewById(R.id.activity_verification_edt_phone_number);
    btnVerify = findViewById(R.id.activity_verification_btn_verify);
    txPhoneErrMessage = findViewById(R.id.activity_verification_txt_phone_err);
    txPhoneErrMessage.setVisibility(View.INVISIBLE);

    // event handlers
    btnVerify.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String phoneNumber = edtPhoneNumber.getText().toString();

        if (phoneNumber.length() == 10 || phoneNumber.length() == 11) {
          openVerificationCodeScreen();
        } else {
          txPhoneErrMessage.setVisibility(View.VISIBLE);
          txPhoneErrMessage.setText("Invalid phone number");
        }
      }
    });
  }

  private void openVerificationCodeScreen() {
    Intent intent = new Intent(this, VerificationCodeActivity.class);
    String phoneNumber = edtPhoneNumber.getText().toString();
    intent.putExtra(PHONE_NUMBER_INTENT, phoneNumber);
    startActivityForResult(intent, SUCCESS_CODE);
  }
}
