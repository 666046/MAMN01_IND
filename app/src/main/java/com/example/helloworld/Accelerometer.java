package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;



public class Accelerometer extends AppCompatActivity implements SensorEventListener{

    private TextView xText, yText, zText, directionDisplay;
    private Sensor mySensor;
    private SensorManager SM;
    private StringBuilder sb;
    private float [] history = new float[2];
    String [] direction = {"NEUTRAL", "NEUTRAL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        //Create StringBuilder

        sb = new StringBuilder();

        //Create our Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);


        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register Sensor Listener
        SM .registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Assign TextView
        xText = (TextView) findViewById(R.id.xText);
        yText = (TextView) findViewById(R.id.yText);
        zText = (TextView) findViewById(R.id.zText);
        directionDisplay = (TextView) findViewById(R.id.directionDisplay);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        float xChange = history[0] - event.values[0];
        float yChange = history[1] - event.values[1];

        history[0] = event.values[0];
        history[1] = event.values[1];

        if(xChange > 2){
            direction[0] = "VÄNSTER";
        }else if(xChange < -2){
            direction[0] = "HÖGER";
        }

        if(yChange > 2){
            direction[1] = "NER";
        }else if(yChange < -2){
            direction[1] = "UPP";
        }

        sb.setLength(0);
        sb.append(direction[0]);
        sb.append(" / ");
        sb.append(direction[1]);



        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);
        directionDisplay.setText(sb.toString());



}

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

        //Not in use

    }
}