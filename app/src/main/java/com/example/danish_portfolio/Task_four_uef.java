package com.example.danish_portfolio;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Task_four_uef extends AppCompatActivity {
    Button live_demo_task_four_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_four_uef);
        live_demo_task_four_button=findViewById(R.id.live_demo_task_four_id);

        live_demo_task_four_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),live_demo_task_four.class));
            }
        });
    }
}