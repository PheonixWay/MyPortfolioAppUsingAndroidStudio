package com.example.danish_portfolio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forget_password extends AppCompatActivity {

    EditText email_for_reset;
    Button send_reset_link_button;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email_for_reset=findViewById(R.id.email_for_reset_id);
        send_reset_link_button=findViewById(R.id.send_reset_link_button_id);
        mAuth=FirebaseAuth.getInstance();

        send_reset_link_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=email_for_reset.getText().toString();
                if (TextUtils.isEmpty(email)){
                    email_for_reset.setError("Email is required");
                    email_for_reset.requestFocus();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    email_for_reset.setError("Enter valid email");
                    email_for_reset.requestFocus();
                }else{
                    resetPassword(email);

                }

            }
        });
    }

    private void resetPassword(String email){
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Successfully send password rest link to your Email",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),login_and_signup_dashboard.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}