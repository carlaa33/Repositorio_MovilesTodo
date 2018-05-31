package mx.edu.ittepic.ciclovida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Button boton;
    public ListView texto;
    public ArrayList<String> metodo;
    public ArrayAdapter<String> adaptador;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        agregarElemento("onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        agregarElemento("onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        agregarElemento("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        agregarElemento("onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        agregarElemento("onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.button);
        texto = findViewById((R.id.listView));
        metodo = new ArrayList<>();
        agregarElemento("onCreate");
    }

    private void agregarElemento(String txt) {
        metodo.add(txt);
        adaptador= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, metodo);
        texto.setAdapter(adaptador);
    }
    public void clear(View v){
        metodo = new ArrayList<>();
        adaptador= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, metodo);
        texto.setAdapter(adaptador);
    }
}

