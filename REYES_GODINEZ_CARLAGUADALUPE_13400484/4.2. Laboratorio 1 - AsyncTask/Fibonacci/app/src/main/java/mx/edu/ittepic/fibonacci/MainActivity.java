package mx.edu.ittepic.fibonacci;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button inicio;
    EditText editNum;
    TextView num;
    int numero,fibo1,fibo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicio=findViewById(R.id.btnIniciar);
        editNum=findViewById(R.id.editNum);
        num=findViewById(R.id.num);
        numero=0;
        fibo1=1;
        fibo2=1;

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editNum.getText().toString().isEmpty()){
                    numero=Integer.parseInt(editNum.getText().toString());
                    new AsyncTarea().execute();
                }
            }
        });
    }

    private class  AsyncTarea extends AsyncTask<Void, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            num.setText("Serie:");
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            publishProgress(fibo1);
            for(int i=2;i<=numero;i++){
                publishProgress(fibo2);
                fibo2 = fibo1 + fibo2;
                fibo1 = fibo2 - fibo1;
                if (isCancelled()){
                    break;
                }
            }
            return true;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            //Actualizar la barra de progreso
            num.setText(num.getText()+"\n"+values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea finaliza AsyncTask",Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();

            Toast.makeText(getApplicationContext(),"Tarea NO finaliza AsyncTask",Toast.LENGTH_SHORT).show();

        }


    }
}
