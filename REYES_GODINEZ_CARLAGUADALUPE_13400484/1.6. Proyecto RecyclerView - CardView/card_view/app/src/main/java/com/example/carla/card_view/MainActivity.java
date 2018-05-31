package com.example.carla.card_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    private String[] colors;

    List<DataProvider> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productList = new ArrayList<>();
        
       
        colors = getResources().getStringArray(R.array.initial_colors);

        
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Aquí va la adición de elementos a la lista
        productList.add(
                new DataProvider("Folklorica", "Sones de la huasteca", 4.3,R.drawable.imagen1)
        );
        productList.add(
                new DataProvider("Rock Alternativo", "Urbano", 4.3,R.drawable.imagen2)
        );
        productList.add(
                new DataProvider("Acusticas", "Guitarras", 4.3,R.drawable.imagen3)
        );
        productList.add(
                new DataProvider("Baladas", "Genero del amor", 4.3,R.drawable.imagen4)
        );

        adapter = new ProductAdapter(this,productList);
        recyclerView.setAdapter(adapter);
    }


}
