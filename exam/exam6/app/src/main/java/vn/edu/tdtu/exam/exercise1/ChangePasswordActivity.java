package vn.edu.tdtu.exam.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.exam.R;

public class ChangePasswordActivity extends AppCompatActivity {
  public static final int SUCCESS_CODE = 200;

  private Button btnVerify;
  private EditText edtPwd, edtConfirmedPwd;
  private TextView txPwdErrMessage, txConfirmPwdErrMessage;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_change_password);

    // lookup views
    edtPwd = findViewById(R.id.activity_verification_edt_pwd);
    edtConfirmedPwd = findViewById(R.id.activity_verification_edt_confirm_pwd);
    btnVerify = findViewById(R.id.activity_verification_btn_verify);
    txPwdErrMessage = findViewById(R.id.activity_verification_txt_pwd_err);
    txConfirmPwdErrMessage = findViewById(R.id.activity_verification_txt_confirm_pw_err);
    txPwdErrMessage.setVisibility(View.INVISIBLE);
    txConfirmPwdErrMessage.setVisibility(View.INVISIBLE);

    // event handlers
    btnVerify.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        boolean isValidForm = true;
        resetErrorMessage();
        String password = edtPwd.getText().toString();
        String confirmedPwd = edtConfirmedPwd.getText().toString();
        int emailLength = password.length();
        if(emailLength < 6){
          txPwdErrMessage.setVisibility(View.VISIBLE);
          txPwdErrMessage.setText("The Password not strong enough! Must be at least 6 characters.");
          isValidForm = false;
        }

        if(!confirmedPwd.equals(password)){
          txConfirmPwdErrMessage.setVisibility(View.VISIBLE);
          txConfirmPwdErrMessage.setText("The password and confirmation password does not match");
          isValidForm = false;
        }

        if(isValidForm) {
          openVerificationCodeScreen();
        }
      }
    });
  }
  private void resetErrorMessage() {
    txPwdErrMessage.setVisibility(View.INVISIBLE);
    txConfirmPwdErrMessage.setVisibility(View.INVISIBLE);
  }

  private void openVerificationCodeScreen() {
    Intent intent = new Intent(this, ConfirmationActivity.class);
    startActivityForResult(intent, SUCCESS_CODE);
  }
}
