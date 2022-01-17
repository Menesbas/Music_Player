package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager mySensorService;
    ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mySensorService = (SensorManager) getSystemService(SENSOR_SERVICE);
        myImageView = (ImageView) findViewById(R.id.imageView2);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            if (sensorEvent.values[0] > 25)
                myImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.morning));
            else
                myImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.night));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override

    protected void onResume() {
        super.onResume();

        mySensorService.registerListener(this, mySensorService.getDefaultSensor(
                Sensor.TYPE_LIGHT), mySensorService.SENSOR_DELAY_NORMAL);
    }

    @Override

    protected void onPause(){
        super.onPause();

        mySensorService.unregisterListener(this);
    }

}
