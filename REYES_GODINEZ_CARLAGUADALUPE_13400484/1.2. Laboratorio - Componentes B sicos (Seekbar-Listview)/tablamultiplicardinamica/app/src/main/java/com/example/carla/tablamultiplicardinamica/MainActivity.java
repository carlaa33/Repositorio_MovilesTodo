package com.example.carla.tablamultiplicardinamica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public EditText edit;
    public Button boton;
    public ListView texto;
    public SeekBar barra;
    public ArrayList<String> operacion;
    public ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.editText);
        boton = (Button) findViewById(R.id.button);
        texto = (ListView) findViewById((R.id.listView));
        barra= (SeekBar) findViewById(R.id.seekBar);
        operacion = new ArrayList<String>();

    }

    public void calcular(View V) {
        int numero = Integer.parseInt(edit.getText().toString());
        int lim= barra.getProgress();
        String txt = "";
        for (int i = 0; i < lim; i++) {
            operacion.add(numero + " * " + (i + 1) + " = " + (numero * (i + 1)) + "\n");
        }
        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,operacion);
        texto.setAdapter(adaptador);
        operacion = new ArrayList<String>();
    }
}
