package mx.edu.ittepic.animacionframe;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable pericoAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.animation);
        if (imageView == null) throw new AssertionError();

        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackgroundResource(R.drawable.perico_animacion);

        pericoAnimation = (AnimationDrawable) imageView.getBackground();
        pericoAnimation.setOneShot(true);
    }

    public void onStartBtnClick(View v) {
        imageView.setVisibility(View.VISIBLE);
        if (pericoAnimation.isRunning()) {
            pericoAnimation.stop();
        }
        pericoAnimation.start();
    }

    public void onStopBtnClick(View v) {
        pericoAnimation.stop();
    }

}