package com.animesh.roy.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        CardView cardView1 = findViewById(R.id.cardView1);
        CardView cardView = findViewById(R.id.cardView);
        TextView welcome = findViewById(R.id.welcome);
        TextView quotes = findViewById(R.id.quotes);
        TextView fly = findViewById(R.id.fly);
        TextView cursive = findViewById(R.id.cursive);
        ImageView plane = findViewById(R.id.imgPlane);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Animation animation, animation2, animationWelcm, animQuotes, animFly, animPlane, cursiveTxt;
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        animationWelcm = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.squential);
        animQuotes = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_next);
        animFly = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.close_next);
        animPlane = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        cursiveTxt = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_next);

        cardView1.startAnimation(animation);
        cardView.startAnimation(animation2);
        welcome.startAnimation(animationWelcm);
        quotes.startAnimation(animQuotes);
        fly.startAnimation(animFly);
        plane.startAnimation(animPlane);
        cursive.startAnimation(cursiveTxt);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(SplashScreen.this,MainActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
