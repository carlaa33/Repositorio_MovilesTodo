package mx.edu.ittepic.pulso;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CountDownTimer intervalo;
    int i;
    double num;
    TextView generado,adivinar,mensaje;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generado=findViewById(R.id.textView);
        adivinar=findViewById(R.id.textView2);
        mensaje=findViewById(R.id.textView3);
        b1=findViewById(R.id.button);
        calclarNum();


        i=0;
        intervalo=new CountDownTimer(30000,300) {
            @Override
            public void onTick(long l) {
                if(i==30){
                    i=0;
                }
                adivinar.setText(""+(((double)i/10.0)));
                i++;
            }

            @Override
            public void onFinish() {
                intervalo.start();
            }
        };
        intervalo.start();
    }

    public void generar(View v){
        if(b1.getText().toString().equals("Generar Número")){
            calclarNum();
        }else{
            reiniciar();
            b1.setText("Generar Número");
        }
    }

    private void calclarNum() {
        num=(((int)(Math.random()*30.0))/10.0);
        generado.setText(num+"");
    }
    public void parar(View v){
        intervalo.cancel();
        b1.setText("Reiniciar");
        if(num==((((double)(i-1))/10.0))){
            mensaje.setTextColor(Color.GREEN);
            mensaje.setText("Lo lograste!");
        }else{
            mensaje.setTextColor(Color.RED);
            mensaje.setText("Vuelve a intentarlo!!");
        }
    }

    public void reiniciar(){
        mensaje.setTextColor(Color.GRAY);
        mensaje.setText("Intentalo!");
        intervalo.start();
    }
}