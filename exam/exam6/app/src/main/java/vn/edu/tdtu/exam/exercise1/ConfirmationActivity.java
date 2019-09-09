package vn.edu.tdtu.exam.exercise1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.admin.exam.R;

public class ConfirmationActivity extends AppCompatActivity {
  private Button btnVerify;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_confirmation);

    // lookup views
    btnVerify = findViewById(R.id.activity_verification_code_btn_submit);

    // event handlers
    btnVerify.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(ConfirmationActivity.this, "Password updated!", Toast.LENGTH_LONG).show();
      }
    });
  }
}
