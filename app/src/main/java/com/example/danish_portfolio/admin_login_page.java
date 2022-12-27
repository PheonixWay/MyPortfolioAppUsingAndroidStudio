package com.example.danish_portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_login_page extends AppCompatActivity {

    EditText private_key;
    Button login_button_for_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);
        private_key=findViewById(R.id.private_key_id);
        login_button_for_admin=findViewById(R.id.admin_login_button_id);
        String code="222002";
        String private_key_v;
        private_key_v=private_key.getText().toString();


        login_button_for_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!private_key.getText().toString().trim().isEmpty()){
                    if (private_key.getText().toString().trim().contentEquals(code)){
                        Intent i=new Intent(getApplicationContext(),admin_homepage.class);
                        startActivity(i);
                        finish();

                    }else{
                        Toast.makeText(getApplicationContext(),"Wrong private key please submit corect key",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    private_key.setError("enter your private key");
                }
            }
        });
    }
}