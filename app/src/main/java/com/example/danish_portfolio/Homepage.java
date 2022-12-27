package com.example.danish_portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {

    FirebaseAuth mAuth;
    ImageButton log_out_button,feedback_button,admin_panel_button,about_me_button,education_button,skills_button,experience_button,contact_button;
    private long Timeback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        mAuth=FirebaseAuth.getInstance();
        feedback_button=findViewById(R.id.feedback_id);
        admin_panel_button=findViewById(R.id.admin_panel_id);
        about_me_button=findViewById(R.id.about_me_id);
        education_button=findViewById(R.id.education_id);
        skills_button=findViewById(R.id.skills_id);
        experience_button=findViewById(R.id.experience_id);
        contact_button=findViewById(R.id.contact_id);
        log_out_button=findViewById(R.id.logout_id);
        mAuth=FirebaseAuth.getInstance();


        feedback_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Inquiry.class));
            }
        });

        admin_panel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),admin_login_page.class));
            }
        });

        about_me_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),about_me_page.class));
            }
        });

        skills_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),skills_page.class));
            }
        });

        contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),contact_page.class));
            }
        });

        education_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),education_page.class));
            }
        });
        experience_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),experience_page.class));
            }
        });
        log_out_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),login_and_signup_dashboard.class));
                finish();
            }
        });
    }
    public void onBackPressed() {
        if (System.currentTimeMillis() - Timeback > 1000) {
            Timeback = System.currentTimeMillis();
            return;
        }
        this.finishAffinity();
    }

}