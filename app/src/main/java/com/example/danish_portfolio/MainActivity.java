package com.example.danish_portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView logo_text;
    ImageView logo;
    Animation wellcomescreen;
    int wait_time=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo=findViewById(R.id.id_logo);
        logo_text=findViewById(R.id.id_logo_text);
        wellcomescreen= AnimationUtils.loadAnimation(this,R.anim.image_animation);

        logo.setAnimation(wellcomescreen);
        logo_text.setAnimation(wellcomescreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, login_and_signup_dashboard.class);
                startActivity(intent);
                finish();

            }
        },wait_time);


    }

}