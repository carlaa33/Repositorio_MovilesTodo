package mx.edu.ittepic.game;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.nyan_cat);
        mp.start();
        setContentView(new Lienzo(this));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
    }

    class Lienzo extends View {
        int xPos;
        CountDownTimer time;
        public Lienzo(Context context){
            super(context);
            xPos=1200;
            time=new CountDownTimer(6000,10) {
                @Override
                public void onTick(long l) {
                    xPos-=10;
                    if(xPos<=-900){
                        xPos=1200;
                    }
                    invalidate();
                }

                @Override
                public void onFinish() {
                    time.start();

                }
            }.start();
        }

        protected void onDraw(Canvas c){
            Paint p = new Paint();

            c.drawColor(Color.BLACK);

            p.setTextSize(100);
            p.setTypeface(Typeface.SERIF);
            p.setColor(Color.WHITE);
            c.drawText("Destruye las naves",xPos,200,p);
            p.setColor(Color.rgb(getRandomColor(),getRandomColor(), getRandomColor()));
            c.drawText("Carla Reyes Godinez",50,1600,p);


            //dibujar un rectangulo

            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.RED);
            c.drawRect(200,900,900,1100,p);

            p.setTextSize(80);
            p.setColor(Color.BLACK);
            c.drawText("Iniciar",440,1020,p);

            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.RED);
            c.drawRect(200,1150,900,1350,p);

            p.setTextSize(80);
            p.setColor(Color.BLACK);
            c.drawText("Salir",460,1270,p);

        }
        public boolean onTouchEvent (MotionEvent e) {
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //programar estado presionado
                    int x = (int) e.getX();
                    int y = (int) e.getY();
                    if(x>= 250 && x<= 950){
                        if (y>= 900 && y<= 1100){
                            Intent ventana=new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(ventana);
                            return true;
                        }
                        if (y>= 1150 && y<= 1350){
                            finish();
                        }
                    }
            }
            return true;
        }

        public int getRandomColor() {
            int color= (int)(Math.random()*(254*1+1)*1);
            return color;
        }
    }

}