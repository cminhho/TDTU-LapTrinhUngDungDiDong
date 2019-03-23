package vn.edu.tdtu.lab02;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Exercise2 extends AppCompatActivity {
    private EditText mEditResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        // Setup UI
        mEditResult = (EditText) findViewById(R.id.editResult);

    }

    public void calculateValue(View v)
    {
        String tagValue = v.getTag().toString();
        mEditResult.setText(mEditResult.getText() + tagValue);
    }
}
