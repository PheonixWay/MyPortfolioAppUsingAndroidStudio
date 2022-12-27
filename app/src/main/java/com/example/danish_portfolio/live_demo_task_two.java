package com.example.danish_portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class live_demo_task_two extends AppCompatActivity {

    EditText first_value,second_value,output;
    Button add,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_demo_task_two);

        first_value=findViewById(R.id.first_number);
        second_value=findViewById(R.id.second_number);
        output=findViewById(R.id.output_id);

        add=findViewById(R.id.add_id);
        sub=findViewById(R.id.sub_id);
        mul=findViewById(R.id.mul_id);
        div=findViewById(R.id.div_id);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float first_number=Float.parseFloat(first_value.getText().toString());
                float second_number=Float.parseFloat(second_value.getText().toString());
                float result=first_number+second_number;
                output.setText(String.valueOf(result));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float first_number=Float.parseFloat(first_value.getText().toString());
                float second_number=Float.parseFloat(second_value.getText().toString());
                float result=first_number-second_number;
                output.setText(String.valueOf(result));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float first_number=Float.parseFloat(first_value.getText().toString());
                float second_number=Float.parseFloat(second_value.getText().toString());
                float result=first_number*second_number;
                output.setText(String.valueOf(result));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float first_number=Float.parseFloat(first_value.getText().toString());
                float second_number=Float.parseFloat(second_value.getText().toString());
                float result=first_number/second_number;
                output.setText(String.valueOf(result));
            }
        });

    }
}