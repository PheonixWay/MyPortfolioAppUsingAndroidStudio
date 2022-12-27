package com.example.danish_portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class task_one_uef extends AppCompatActivity {
    Button live_demo_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one_uef);

        live_demo_button=findViewById(R.id.live_demo_id);

        live_demo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),live_demo_task_one.class));
            }
        });
    }
}