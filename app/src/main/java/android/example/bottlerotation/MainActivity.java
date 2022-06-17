package android.example.bottlerotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView i;
    Random rand = new Random();
    boolean spin;
    int lsdr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = findViewById(R.id.bottle);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!spin)
                {
                    int num = rand.nextInt(1800);
                    float px = i.getWidth()/2;
                    float py = i.getHeight()/2;
                    Animation rot = new RotateAnimation(lsdr,num,px,py);
                    rot.setDuration(2500);
                    rot.setFillAfter(true);
                    rot.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            spin = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            spin = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    lsdr = num;
                    i.startAnimation(rot);
                }

            }
        });
    }
}