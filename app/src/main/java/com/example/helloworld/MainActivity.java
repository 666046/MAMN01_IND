package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void compassView(View view) {

        // Intent provides runtime binding between separate components "intent to do something"
        // Context for parameter, this is used because the Activity class is a subclass of Context
        // And the Class of the app component to which the system should deliver the Intent
        Intent intent = new Intent(this, Compass.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void accelerometerView(View view) {

        // Intent provides runtime binding between separate components "intent to do something"
        // Context for parameter, this is used because the Activity class is a subclass of Context
        // And the Class of the app component to which the system should deliver the Intent
        Intent intent = new Intent(this, Accelerometer.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
