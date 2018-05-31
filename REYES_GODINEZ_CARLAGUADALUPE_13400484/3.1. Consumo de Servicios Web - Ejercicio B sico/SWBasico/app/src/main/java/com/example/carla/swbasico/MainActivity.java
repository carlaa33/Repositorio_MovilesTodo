package com.example.carla.swbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button click;
    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = findViewById(R.id.getBtn);
        data = findViewById(R.id.showData);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJson process = new GetJson();
                process.execute();
            }
        });
    }
}
