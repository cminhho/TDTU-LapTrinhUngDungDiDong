package tdtu.edu.vn.lab02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Exercise2Activity extends AppCompatActivity {
    private EditText edtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        edtResult = findViewById(R.id.activity_exercise2_edt_result);
    }

    public void calculateValue(View v) {
        String tagValue = v.getTag().toString();
        String result = edtResult.getText().toString() + tagValue;
        edtResult.setText(result);
    }
}