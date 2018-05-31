package com.example.carla.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Alumnos> listaalumnos;
    RecyclerView recyclerAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaalumnos=new ArrayList<>();
        recyclerAlumnos=(RecyclerView) findViewById(R.id.recycler_id);
        recyclerAlumnos.setLayoutManager(new LinearLayoutManager(this));

        llenarAlumnos();

        RecyclerAdapter adapter= new RecyclerAdapter(listaalumnos);
        recyclerAlumnos.setAdapter(adapter);
    }

    private void llenarAlumnos(){

        listaalumnos.add(new Alumnos("Jose Angel Montoya","13400452"," ISC",R.drawable.alumno));
        listaalumnos.add(new Alumnos("Erika Lizbeth Martinez Bañuelos","13400452"," ISC",R.drawable.alumno));
        listaalumnos.add(new Alumnos("Miguel Angel Lopez Ibarria","13400452"," IE",R.drawable.alumno));
        listaalumnos.add(new Alumnos("Brayan de Jesus Gutierrez Esparza","13400452"," ISC",R.drawable.alumno));
        listaalumnos.add(new Alumnos("ARANDA PATRON NOMAR JAZIEL","13400452"," ISC",R.drawable.alumno));
        listaalumnos.add(new Alumnos("VALDEZ LOPEZ HOLLIVER EDUARDO","13400452"," ISC",R.drawable.alumno));
        listaalumnos.add(new Alumnos("RIVERA RAMIREZ DAVID","13400452"," ISC",R.drawable.alumno));
        listaalumnos.add(new Alumnos("SILVA CAMACHO EDUARDO LUIS","13400452"," ISC",R.drawable.alumno));
        listaalumnos.add(new Alumnos("TORRES CUETO JESUS MANUEL","13400452"," ISC",R.drawable.alumno));
    }
}