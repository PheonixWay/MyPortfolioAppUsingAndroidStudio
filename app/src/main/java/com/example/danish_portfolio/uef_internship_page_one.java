package com.example.danish_portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class uef_internship_page_one extends AppCompatActivity {
    Button task_1_button,task_2_button,task_3_button,task_4_button,task_5_button,task_6_button,task_7_button,
            task_8_button,task_9_button,task_10_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uef_internship_page_one);

        task_1_button=findViewById(R.id.task_1_id);
        task_2_button=findViewById(R.id.task_2_id);
        task_3_button=findViewById(R.id.task_3_id);
        task_4_button=findViewById(R.id.task_4_id);
        task_5_button=findViewById(R.id.task_5_id);
        task_6_button=findViewById(R.id.task_6_id);
        task_7_button=findViewById(R.id.task_7_id);
        task_8_button=findViewById(R.id.task_8_id);
        task_9_button=findViewById(R.id.task_9_id);
        task_10_button=findViewById(R.id.task_10_id);

        task_1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), task_one_uef.class));
            }
        });

        task_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),task_two_uef.class));
            }
        });

        task_3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),task_three_uef.class));
            }
        });

        task_4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Task_four_uef.class));
            }
        });

        task_5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Task_five_uef.class));
            }
        });
        task_6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Task_six_uef.class));
            }
        });
    }
}