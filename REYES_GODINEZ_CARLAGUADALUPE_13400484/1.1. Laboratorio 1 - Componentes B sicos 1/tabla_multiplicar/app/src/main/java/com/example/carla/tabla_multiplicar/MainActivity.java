package com.example.carla.tabla_multiplicar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText edit;
    public Button boton;
    public TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.editText);
        boton = (Button) findViewById(R.id.button);
        texto = (TextView) findViewById((R.id.textView3));

    }

    public void calcular(View V) {
        int numero = Integer.parseInt(edit.getText().toString());
        String txt = "";
        for (int i = 0; i < 10; i++) {
            txt += numero + " * " + (i + 1) + " = " + (numero * (i + 1)) + "\n";
        }
        texto.setText(txt);
    }
}
