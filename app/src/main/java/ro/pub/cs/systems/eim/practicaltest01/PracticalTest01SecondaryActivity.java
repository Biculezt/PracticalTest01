package ro.pub.cs.systems.eim.practicaltest01;

import static ro.pub.cs.systems.eim.practicaltest01.Constants.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {
    TextView resultTextView;
    Button okButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

             resultTextView = findViewById(R.id.text_view_click);
                okButton = findViewById(R.id.ok_button);
                cancelButton = findViewById(R.id.cancel_button);

              okButton.setOnClickListener(it -> {
                  setResult(RESULT_OK, null);
                  finish();
              });

              cancelButton.setOnClickListener(it -> {
                  setResult(RESULT_CANCELED, null);
                  finish();
              });



        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                resultTextView.setText("0");
            } else {
                Integer left = extras.getInt(LEFT);
                Integer right = extras.getInt(RIGHT);
                resultTextView.setText(String.valueOf(left + right));
            }
            }else {
                resultTextView.setText(savedInstanceState.getString(String.valueOf(resultTextView)));
            }
        }



    }
