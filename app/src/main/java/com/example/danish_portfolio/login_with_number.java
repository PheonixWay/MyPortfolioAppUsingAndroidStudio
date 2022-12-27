package com.example.danish_portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.security.PrivateKey;
import java.util.concurrent.TimeUnit;

public class login_with_number extends AppCompatActivity {

    EditText phone_number;
    Button submit_button;
    TextView error_view,complete_msg;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_number);

        phone_number=findViewById(R.id.phone_number_id);
        submit_button=findViewById(R.id.submit_id);
        error_view=findViewById(R.id.error_show_id);
        String msg_1="Enter 10 digit number";
        String msg_2="Enter the phone number";
        String msg_3="Enter correct number";
        complete_msg=findViewById(R.id.complete_show_id);
        mAuth=FirebaseAuth.getInstance();


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!phone_number.getText().toString().trim().isEmpty()){
                    if (phone_number.getText().toString().trim().length() ==10){
                        sendCode();
                    }
                    else {
                        error_view.setText(msg_1);
                    }
                }
                else {
                    error_view.setText(msg_2);
                }
            }
        });

    }
    private void sendCode(){
        String number=phone_number.getText().toString();

        PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {


            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }

            @Override
            public void onCodeSent(@NonNull String otp_to_check,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                Intent i =new Intent(login_with_number.this,login_with_number_otp_submit_page.class);
                i.putExtra("phoneNumber",number);
                i.putExtra("otp_to_check",otp_to_check);
                complete_msg.setText("code sent");
                startActivity(i);
                finish();

            }
        };

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+number)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(login_with_number.this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}