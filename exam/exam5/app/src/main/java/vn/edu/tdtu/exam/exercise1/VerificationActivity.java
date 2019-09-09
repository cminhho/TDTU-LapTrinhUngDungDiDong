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
  private static final String TDTU_EMAIL_PATTERN = "@tdtu.edu.vn";
  private static final int TDTU_EMAIL_PATTERN_SIZE = TDTU_EMAIL_PATTERN.length();
  public static final String EMAIL_ADDRESS_INTENT = "EMAIL_ADDRESS";
  public static final int SUCCESS_CODE = 200;

  private Button btnVerify;
  private EditText edtEmail;
  private TextView txErrMessage;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verification);

    // lookup views
    edtEmail = findViewById(R.id.activity_verification_edt_email);
    btnVerify = findViewById(R.id.activity_verification_btn_verify);
    txErrMessage = findViewById(R.id.activity_verification_txt_err);
    txErrMessage.setVisibility(View.INVISIBLE);

    // event handlers
    btnVerify.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        String email = edtEmail.getText().toString();
        int emailLength = email.length();
        if(emailLength - TDTU_EMAIL_PATTERN_SIZE < 0){
          displayErrorMessage("Invalid email address");
          return;
        }
        if (isValidTdtuEmail(email)) {
          openVerificationCodeScreen();
        } else {
          displayErrorMessage("Invalid email address");
        }
      }
    });
  }

  private boolean isValidTdtuEmail(String email) {
    int emailLength = email.length();
    String tdtuEmailDomain = email.substring(email.length() - (TDTU_EMAIL_PATTERN_SIZE), emailLength);
    return  tdtuEmailDomain.equals(TDTU_EMAIL_PATTERN);
  }

  private void displayErrorMessage(String errMessage) {
    txErrMessage.setVisibility(View.VISIBLE);
    txErrMessage.setText(errMessage);
  }

  private void openVerificationCodeScreen() {
    Intent intent = new Intent(this, VerificationCodeActivity.class);
    String email = edtEmail.getText().toString();
    intent.putExtra(EMAIL_ADDRESS_INTENT, email);
    startActivityForResult(intent, SUCCESS_CODE);
  }
}
