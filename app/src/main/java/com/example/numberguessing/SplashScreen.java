package com.example.numberguessing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Animation animationImage;
    Animation animationText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView=findViewById(R.id.hachem);
        textView=findViewById(R.id.hachem1);
        animationImage= AnimationUtils.loadAnimation(this,R.anim.image_animation);
        animationText=AnimationUtils.loadAnimation(this,R.anim.text_anim);
        imageView.setAnimation(animationImage);
        textView.setAnimation(animationText);
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
              startActivity(new Intent(SplashScreen.this, MainActivity.class));
              finish();
            }
        }.start();

    }
}