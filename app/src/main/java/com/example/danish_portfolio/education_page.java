package com.example.danish_portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class education_page extends AppCompatActivity {

    Button view_result_ssc_button,view_result_hsc_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_page);
        view_result_ssc_button=findViewById(R.id.view_result_ssc_id);
        view_result_hsc_button=findViewById(R.id.view_result_hsc_id);

        view_result_ssc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),result_ssc_page.class));

            }
        });
        view_result_hsc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),hsc_result_page.class));
            }
        });
    }
}