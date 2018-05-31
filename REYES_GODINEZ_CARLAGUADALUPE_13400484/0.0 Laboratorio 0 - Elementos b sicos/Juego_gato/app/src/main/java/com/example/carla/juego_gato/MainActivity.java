package com.example.carla.juego_gato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public class JuegoGato {
        //Variables.
        public char[][] tablero;
        public char jugadorUno;
        public char jugadorDos;
        public boolean turno;
        int contador;

        //Constructor(Inicializa Variables).
        public JuegoGato() {

            tablero = new char[3][3];
            jugadorUno = 'X';
            jugadorDos = 'O';
            turno = true;  //Si El Valor De "turno" Es Igual A "true" El Turno Es Del Jugador 1, De Lo Contrario Es Jugador 2.
            int contador = 0;     //Lleva Cuenta De Las Veces Que Han Participado Los Jugadores 1 y 2.
            
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
