package mx.edu.ittepic.game;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    class Lienzo extends View {
        int desplazamiento=220;
        Nave nave= new Nave();
        Bala bala= new Bala();
        CountDownTimer timer;
        ArrayList<Stars> estrella= new ArrayList<Stars>();
        Bala ba1=new Bala();
        Bala ba2=new Bala();
        Bala ba3=new Bala();
        ArrayList<Alien> aliens= new ArrayList<Alien>();
        int gxi,gxe,pxi,pxe;
        int gyi,gye,pyi,pye;
        boolean direction=false;//false=derecha, true=izquierda
        int contador=100;
        public Lienzo(Context context) {
            super(context);
            initStars();
            initAlien();
            initPositionAlien();
            timer= new CountDownTimer(20000,50) {
                @Override
                public void onTick(long millisUntilFinished) {
                    bala.cy-=15;
                    inicio(ba1);
                    inicio(ba2);
                    inicio(ba3);

                    for(int i=0;i<=5;i++){
                        if(direction==false){
                            if(contador>0){
                                //fila1
                                aliens.get(i).gcxi+=15;
                                aliens.get(i).gcxe+=15;
                                aliens.get(i).pcxi+=15;
                                aliens.get(i).pcxe+=15;
                                //fila2
                                aliens.get(i+6).gcxi+=15;
                                aliens.get(i+6).gcxe+=15;
                                aliens.get(i+6).pcxi+=15;
                                aliens.get(i+6).pcxe+=15;
                                //fila3
                                aliens.get(i+12).gcxi+=15;
                                aliens.get(i+12).gcxe+=15;
                                aliens.get(i+12).pcxi+=15;
                                aliens.get(i+12).pcxe+=15;
                                contador--;
                            }
                            else{
                                contador=150;
                                direction=true;
                            }
                        }
                        else{
                            if(contador>0){
                                //fila1
                                aliens.get(i).gcxi-=15;
                                aliens.get(i).gcxe-=15;
                                aliens.get(i).pcxi-=15;
                                aliens.get(i).pcxe-=15;
                                //fila2
                                aliens.get(i+6).gcxi-=15;
                                aliens.get(i+6).gcxe-=15;
                                aliens.get(i+6).pcxi-=15;
                                aliens.get(i+6).pcxe-=15;
                                //fila3
                                aliens.get(i+12).gcxi-=15;
                                aliens.get(i+12).gcxe-=15;
                                aliens.get(i+12).pcxi-=15;
                                aliens.get(i+12).pcxe-=15;
                                contador--;
                            }
                            else{
                                contador=150;
                                direction=false;
                            }
                        }
                    }
                    checkBala();
                    deleteAlien();
                    decVida(ba1,1);
                    decVida(ba2,2);
                    decVida(ba3,3);
                    invalidate();
                }
                @Override
                public void onFinish() {
                    start();
                }
            };
            timer.start();
        }
        private void decVida(Bala b,int i) {
            if(b.cx-10>nave.otinix && b.cx+10<nave.fendx && b.cy>610 && b.cy<750){
                if(i==1)ba1=new Bala();
                if(i==2)ba2=new Bala();
                if(i==3)ba3=new Bala();
                nave.vidas--;
            }
        }
        private void inicio(Bala b) {
            int n=(int)(Math.random()*17);
            if(aliens.get(n).visible && (int)(Math.random()*20)==4 && b.activa==false){
                b.activa=true;
                b.cx=((aliens.get(n).gcxe+aliens.get(n).gcxi)/2);
                b.cy=(aliens.get(n).gcye);
            }

            if(b.activa) {
                if(b.cy<1920){
                    b.cy+=15;
                }else{
                    b.activa=false;
                }
            }



        }
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        protected void onDraw(Canvas c){
            Paint p= new Paint();
            //fondo
            p.setColor(Color.BLACK);
            p.setStyle(Paint.Style.FILL);
            c.drawRect(0,0,1920,1080,p);
            //Estrellas
            for (int i = 0; i < estrella.size(); i++) {
                p.setColor(Color.argb(getRandomColor(),255 , 255, 255));
                c.drawCircle(estrella.get(i).cx, estrella.get(i).cy, estrella.get(i).radio, p);
            }
            if(nave.vidas>0) {
                //techo
                p.setColor(Color.GRAY);
                c.drawOval(nave.otinix, 600, nave.otendx, 640, p);
                //Fuego
                p.setColor(Color.RED);
                p.setStyle(Paint.Style.FILL);
                c.drawOval(nave.finitx, 745, nave.fendx, 760, p);
                //cuerpo
                p.setColor(Color.WHITE);
                c.drawRect(nave.inix, 620, nave.endx, 750, p);
                //Ventana
                p.setColor(Color.CYAN);
                c.drawCircle(nave.rx, 640, 15, p);
                //Puerta
                p.setColor(Color.GRAY);
                p.setStyle(Paint.Style.FILL);
                c.drawRect(nave.pinitx, 690, nave.pendx, 745, p);
            }else{
                p.setTextSize(100);
                p.setColor(Color.RED);
                c.drawText("Perdiste",800,800,p);
            }

            //Bala nave
            if(bala.activa==true && nave.vidas>0){
                p.setColor(Color.argb(255,getRandomColor(),getRandomColor(),getRandomColor()));
                c.drawCircle(bala.cx,bala.cy,bala.radio,p);
            }
            if(ba1.activa){
                p.setColor(Color.RED);
                c.drawCircle(ba1.cx,ba1.cy,ba1.radio,p);
            }
            if(ba2.activa){
                p.setColor(Color.RED);
                c.drawCircle(ba2.cx,ba2.cy,ba2.radio,p);
            }
            if(ba3.activa){
                p.setColor(Color.RED);
                c.drawCircle(ba3.cx,ba3.cy,ba3.radio,p);
            }
            int contador=0;
            for(int i=0;i<aliens.size();i++){
                if(aliens.get(i).visible) {
                    p.setColor(Color.GRAY);
                    c.drawOval(aliens.get(i).gcxi, aliens.get(i).gcyi, aliens.get(i).gcxe, aliens.get(i).gcye, p);
                    p.setColor(Color.BLUE);
                    c.drawOval(aliens.get(i).pcxi, aliens.get(i).pcyi, aliens.get(i).pcxe, aliens.get(i).pcye, p);
                    contador++;
                }
            }

            if(contador==0){
                p.setColor(Color.argb(255,getRandomColor(),getRandomColor(),getRandomColor()));
                p.setTextSize(100);
                c.drawText("Ganaste",800,800,p);
            }
        }
        private int getRandomColor(){
            int color= (int)(Math.random()*(254*1+1)*1);
            return color;
        }
        public void initStars(){
            Stars aux;
            for(int i=0;i<200;i++){
                aux=new Stars();
                estrella.add(aux);
            }
        }
        public void initAlien(){
            Alien aux;boolean reset=false;
            for(int i=0;i<18;i++){
                aux= new Alien();
                aliens.add(aux);
            }
        }
        public void initPositionAlien(){
            gxi=200;gxe=300;
            pxi=210;pxe=290;
            gyi=50;gye=100;
            pyi=55;pye=85;
            for(int i=0;i<=5;i++){
                aliens.get(i).gcxi=(gxi+=desplazamiento);
                aliens.get(i).gcxe=(gxe+=desplazamiento);
                aliens.get(i).pcxi=(pxi+=desplazamiento);
                aliens.get(i).pcxe=(pxe+=desplazamiento);
                aliens.get(i).gcyi=gyi;
                aliens.get(i).gcye=gye;
                aliens.get(i).pcyi=pyi;
                aliens.get(i).pcye=pye;
            }
            gxi=200;gxe=300;
            pxi=210;pxe=290;
            gyi=150;gye=200;
            pyi=155;pye=185;
            for(int i=6;i<=11;i++){
                aliens.get(i).gcxi=(gxi+=desplazamiento);
                aliens.get(i).gcxe=(gxe+=desplazamiento);
                aliens.get(i).pcxi=(pxi+=desplazamiento);
                aliens.get(i).pcxe=(pxe+=desplazamiento);
                aliens.get(i).gcyi=gyi;
                aliens.get(i).gcye=gye;
                aliens.get(i).pcyi=pyi;
                aliens.get(i).pcye=pye;
            }
            gxi=200;gxe=300;
            pxi=210;pxe=290;
            gyi=250;gye=300;
            pyi=255;pye=285;
            for(int i=12;i<=17;i++){
                aliens.get(i).gcxi=(gxi+=desplazamiento);
                aliens.get(i).gcxe=(gxe+=desplazamiento);
                aliens.get(i).pcxi=(pxi+=desplazamiento);
                aliens.get(i).pcxe=(pxe+=desplazamiento);
                aliens.get(i).gcyi=gyi;
                aliens.get(i).gcye=gye;
                aliens.get(i).pcyi=pyi;
                aliens.get(i).pcye=pye;
            }

        }
        public boolean onTouchEvent(MotionEvent e){

            switch (e.getAction()){
                case MotionEvent.ACTION_DOWN:
                    //Cuando se presiona
                    break;
                case MotionEvent.ACTION_MOVE:
                    //Cuando despues de presionar, se arrastra
                    nave.inix=(int)e.getX()-25;
                    nave.endx=(int)e.getX()+25;
                    nave.rx=(int)e.getX();
                    nave.otinix+=(int)e.getX()-25;
                    nave.otendx=(int)e.getX()+25;
                    nave.finitx=(int)e.getX()-25;
                    nave.fendx=(int)e.getX()+25;
                    nave.pinitx=(int)e.getX()-10;
                    nave.pendx=(int)e.getX()+10;
                    break;
                case MotionEvent.ACTION_UP:
                    //Cuando despues de presionar, se libera
                    if(bala.activa==false){
                        bala.activa=true;
                        bala.cy=590;
                        bala.cx=nave.otinix+25;//(int)e.getX();
                    }
                    break;
            }
            invalidate();
            return true;
        }
        private void checkBala(){
            if(bala.cy<0){
                bala= new Bala();
            }
        }
        private void deleteAlien() {
            for (int i=0;i<aliens.size();i++){
                if((bala.cx-10)>(aliens.get(i).gcxi) && (bala.cx+10)<(aliens.get(i).gcxe) && aliens.get(i).visible){
                    if((bala.cy-10)>(aliens.get(i).gcyi) && (bala.cy+10)<(aliens.get(i).gcye)&& aliens.get(i).visible){
                        //aliens.remove(i);
                        aliens.get(i).visible=false;
                        bala= new Bala();

                    }
                }
            }
        }
    }
}
