package com.example.danish_portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class experience_page extends AppCompatActivity {
    Button view_uef_internship_button,view_my_projects_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_page);
        view_uef_internship_button=findViewById(R.id.uef_internship_id);
        view_my_projects_button=findViewById(R.id.my_projects_id);

        view_uef_internship_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),uef_internship_page_one.class));

            }
        });

        view_my_projects_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),my_project_page_one.class));

            }
        });

    }
}