package ro.pub.cs.systems.eim.practicaltest01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {

    Button pressMeButton;
    Button pressMeTooButton;
    EditText leftEditText;
    EditText rightEditText;

    Integer leftClicks = 0;
    Integer rightClicks = 0;

    Button navigateToSecondaryActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        pressMeButton = (Button) findViewById(R.id.press_me_button);
        pressMeTooButton = (Button) findViewById(R.id.press_me_too_button);
        leftEditText = (EditText) findViewById(R.id.left_edit_text);
        rightEditText = (EditText) findViewById(R.id.right_edit_text);
        navigateToSecondaryActivityButton = (Button) findViewById(R.id.navigate_to_secondary_activity_button);

        pressMeButton.setOnClickListener(it -> {
            leftClicks++;
            leftEditText.setText(String.valueOf(leftClicks));
        });
        pressMeTooButton.setOnClickListener(it -> {
            rightClicks++;
            rightEditText.setText(String.valueOf(rightClicks));
        });

        navigateToSecondaryActivityButton.setOnClickListener(it -> {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
            intent.putExtra(Constants.LEFT, leftClicks);
            intent.putExtra(Constants.RIGHT, rightClicks);
            startActivityForResult(intent, 1);
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(Constants.LEFT, leftClicks);
        outState.putInt(Constants.RIGHT, rightClicks);

        leftEditText.setText(String.valueOf(leftClicks));
        rightEditText.setText(String.valueOf(rightClicks));

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

      leftClicks = savedInstanceState.getInt(Constants.LEFT);
        rightClicks = savedInstanceState.getInt(Constants.RIGHT);

            leftEditText.setText(String.valueOf(leftClicks));
            rightEditText.setText(String.valueOf(rightClicks));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "The activity returned with result CANCEL", Toast.LENGTH_LONG).show();
            }
        }
    }


}