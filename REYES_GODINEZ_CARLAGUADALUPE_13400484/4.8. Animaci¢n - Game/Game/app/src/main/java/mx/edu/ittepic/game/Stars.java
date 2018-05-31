package mx.edu.ittepic.game;

public class Stars {
    public int cx;
    public int cy;
    public int radio;
    public Stars(){
        radio=((int)(Math.random()*(6*1+1)+1))+1;
        cx=(int)(Math.random()*(2048*1+1)+1);
        cy=(int)(Math.random()*(1536*1+1)+1);
    }

}
