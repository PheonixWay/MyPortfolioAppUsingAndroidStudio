package com.example.danish_portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.TextUtils;
import android.util.Patterns;
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
import java.util.regex.Pattern;

public class signup_with_mail extends AppCompatActivity {
    TextView email_for_register,password_for_register;
    Button register_with_email_password_button;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_with_mail);
        email_for_register=findViewById(R.id.email_register_id);
        password_for_register=findViewById(R.id.password_register_id);
        register_with_email_password_button=findViewById(R.id.register_id);
        mAuth=FirebaseAuth.getInstance();
        register_with_email_password_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createuser();

            }
        });

    }

    private void createuser(){
        String email=email_for_register.getText().toString();
        String password=password_for_register.getText().toString();
        if(TextUtils.isEmpty(email)){
            email_for_register.setError("Enter Email");
            email_for_register.requestFocus();
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            email_for_register.setError("Enter valid email");
            email_for_register.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            password_for_register.setError("Enter password");
            password_for_register.requestFocus();

        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(signup_with_mail.this,"Successfully Created Your Account",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signup_with_mail.this,login_page_with_mail.class));

                    }
                    else {
                        Toast.makeText(signup_with_mail.this,"Registration Error"+ Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }

    }

}