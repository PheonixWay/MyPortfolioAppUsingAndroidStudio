package com.example.danish_portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class live_demo_task_five extends AppCompatActivity {

    ImageView image;
    TextView text;
    Animation image_animation,text_animation;
    int wait_time=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_demo_task_five);
        image=findViewById(R.id.image_for_live_demo_five_id);
        text=findViewById(R.id.demo_text_id);

        image_animation= AnimationUtils.loadAnimation(this,R.anim.fade_animation);
        text_animation= AnimationUtils.loadAnimation(this,R.anim.blink);

        image.setAnimation(image_animation);
        text.setAnimation(text_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),homepage_for_live_demo_five.class);
                startActivity(intent);
                finish();

            }
        },wait_time);
    }
}