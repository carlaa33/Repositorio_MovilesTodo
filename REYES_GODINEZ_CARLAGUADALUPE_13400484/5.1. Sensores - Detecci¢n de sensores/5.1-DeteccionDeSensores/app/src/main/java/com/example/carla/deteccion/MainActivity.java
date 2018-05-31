package com.example.carla.deteccion;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    RecyclerView recyclerView;
    DetallesAdapter adapter;
    List<DataProvider> sensorList;

    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorList=new ArrayList<>();

        recyclerView=findViewById(R.id.RV);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        List<Sensor> lista = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(int i=1; i<lista.size(); i++){
            sensorList.add(
                    new DataProvider(lista.get(i).getName(),lista.get(i).getVendor(),lista.get(i).getVersion(),lista.get(i).getMaximumRange(),lista.get(i).getMinDelay(),lista.get(i).getPower())
            );
        }
        adapter = new DetallesAdapter(this,sensorList);
        recyclerView.setAdapter(adapter);
    }
}