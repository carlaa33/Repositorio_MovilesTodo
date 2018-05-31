package mx.edu.ittepic.animacionxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.faceIcon);

    }

    public void animacion1(View v) {
        Animation animation =AnimationUtils.loadAnimation(this, R.anim.grow);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setScaleX(2);
                imageView.setScaleY(2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        imageView.startAnimation(animation);
    }

    public void animacion2(View v) {
        Animation animation =AnimationUtils.loadAnimation(this, R.anim.traslacion);
        animation.setRepeatCount(4);

        imageView.startAnimation(animation);
    }

    public void animacion3(View v) {
        Animation animation =AnimationUtils.loadAnimation(this, R.anim.girar);
        animation.setRepeatCount(1);

        imageView.startAnimation(animation);
    }

    public void animacion4(View v) {
        Animation animation =AnimationUtils.loadAnimation(this, R.anim.aparecer);
        animation.setRepeatCount(4);

        imageView.startAnimation(animation);
    }

}
