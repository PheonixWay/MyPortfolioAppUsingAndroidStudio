package com.example.danish_portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class login_with_number_otp_submit_page extends AppCompatActivity {
    EditText num_1,num_2,num_3,num_4,num_5,num_6;
    TextView show_phone_number_view,show_error_view;
    Button login_button;
    String verification_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_number_otp_submit_page);
        num_1=findViewById(R.id.number_1);
        num_2=findViewById(R.id.number_2);
        num_3=findViewById(R.id.number_3);
        num_4=findViewById(R.id.number_4);
        num_5=findViewById(R.id.number_5);
        num_6=findViewById(R.id.number_6);
        login_button=findViewById(R.id.login_id);
        show_phone_number_view=findViewById(R.id.show_number);
        show_error_view=findViewById(R.id.error_show_id);


        String number_from_other_activity= getIntent().getStringExtra("phoneNumber");
        show_phone_number_view.setText(number_from_other_activity);
        verification_code=getIntent().getStringExtra("otp_to_check");

        move_To_Next();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });




    }
    private void login(){
        String msg_1="Please Check your internet connection";
        String msg_2="Enter your OTP";
        if (!num_1.getText().toString().trim().isEmpty()&&
                !num_2.getText().toString().trim().isEmpty()&&
                !num_3.getText().toString().trim().isEmpty()&&
                !num_4.getText().toString().trim().isEmpty()&&
                !num_5.getText().toString().trim().isEmpty()&&
                !num_6.getText().toString().trim().isEmpty()){
            String otp_to_check= num_1.getText().toString()+
                    num_2.getText().toString()+
                    num_3.getText().toString()+
                    num_4.getText().toString()+
                    num_5.getText().toString()+
                    num_6.getText().toString();
            if(verification_code!=null){
                PhoneAuthCredential phoneAuthProvider=PhoneAuthProvider.getCredential(verification_code,otp_to_check);
                FirebaseAuth.getInstance().signInWithCredential(phoneAuthProvider).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Successfully login",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(login_with_number_otp_submit_page.this, Homepage.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Error in login",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }else {
                show_error_view.setText(msg_1);

            }

        }
        else {
            show_error_view.setText(msg_2);

        }
    }
    private void move_To_Next(){
        num_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    num_2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        num_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    num_3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        num_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    num_4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        num_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    num_5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        num_5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    num_6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}