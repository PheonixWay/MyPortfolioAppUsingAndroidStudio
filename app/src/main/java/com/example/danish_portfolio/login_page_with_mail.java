package com.example.danish_portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class login_page_with_mail extends AppCompatActivity {

    TextView email_for_login,password_for_login,forget_password_button;
    Button login_with_email_button;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_with_mail);

        //casting
        email_for_login=findViewById(R.id.login_email_id);
        password_for_login=findViewById(R.id.login_password_id);
        login_with_email_button=findViewById(R.id.email_login_button_id);
        forget_password_button=findViewById(R.id.forget_password_id);
        //initializing firebaseAuth object
        mAuth=FirebaseAuth.getInstance();


        login_with_email_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
        forget_password_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),forget_password.class));
            }
        });


    }

    private void loginUser() {
        String email=email_for_login.getText().toString();
        String password=password_for_login.getText().toString();
        if(TextUtils.isEmpty(email)){
            email_for_login.setError("Enter Email");
            email_for_login.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            password_for_login.setError("Enter password");
            password_for_login.requestFocus();

        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(login_page_with_mail.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login_page_with_mail.this, Homepage.class));
                        finish();
                    }
                    else{
                        Toast.makeText(login_page_with_mail.this,"Login Error"+ Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}