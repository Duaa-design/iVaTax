package com.example.ivatax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//variables
    //it mean 5 second
private  static  int SPLASH_SCREEN =5000;
    Animation top_anim , button_anim;

ImageView percentage;
TextView itax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call the animation
top_anim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        button_anim= AnimationUtils.loadAnimation(this,R.anim.button_anim);


        percentage=findViewById(R.id.percentage);
        itax=findViewById(R.id.itax);

        //assign the animation to the text

        percentage.setAnimation(top_anim);
        itax.setAnimation(button_anim);
     //   Handler() will handle the delay process
    new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent = new Intent(MainActivity.this,Calculater.class);
       startActivity(intent);
        finish();
    }
},SPLASH_SCREEN);
    }
}