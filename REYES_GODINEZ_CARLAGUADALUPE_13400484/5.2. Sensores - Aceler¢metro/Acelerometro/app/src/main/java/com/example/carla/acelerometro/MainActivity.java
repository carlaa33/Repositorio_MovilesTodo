package com.example.carla.acelerometro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor mysensor;
    private SensorManager senman;

    TextView ejeX,ejeY,ejeZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ejeX = findViewById(R.id.ejeX);
        ejeY = findViewById(R.id.ejeY);
        ejeZ = findViewById(R.id.ejeZ);

        senman = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor mysensor=senman.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        senman.registerListener(this,mysensor,SensorManager.SENSOR_DELAY_NORMAL);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        ejeX.setText("X:"+event.values[0]);
        ejeY.setText("Y:"+event.values[1]);
        ejeZ.setText("Z:"+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
