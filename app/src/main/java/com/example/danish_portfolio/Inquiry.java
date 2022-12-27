package com.example.danish_portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Inquiry extends AppCompatActivity {

    EditText full_name,email,number,message;
    Button inquiry_submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);

        full_name=findViewById(R.id.inquiry_full_name_id);
        email=findViewById(R.id.inquiry_email_id);
        number=findViewById(R.id.inquiry_number_id);
        message=findViewById(R.id.inquiry_message_id);
        inquiry_submit_button=findViewById(R.id.inquiry_submit_id);

        inquiry_submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitInquiry();
            }
        });

    }
    private void submitInquiry(){

        final String full_name_s=full_name.getText().toString();
        final String number_s=number.getText().toString();
        final String message_s=message.getText().toString();
        final String email_s=email.getText().toString();

        if(TextUtils.isEmpty(full_name_s)){
            full_name.setError("Enter name");
        }else if(TextUtils.isEmpty(email_s)){
            email.setError("Enter email");
        }else if (TextUtils.isEmpty(number_s)){
            number.setError("Enter your phone number");
        }else if (TextUtils.isEmpty(message_s)){
            message.setError("Enter message");
        }else{
            HashMap<String,Object> map=new HashMap<>();
            map.put("name",full_name_s);
            map.put("email",email_s);
            map.put("number",number_s);
            map.put("message",message_s);

            FirebaseDatabase.getInstance().getReference().child("inquiry").push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        full_name.setText(null);
                        email.setText(null);
                        number.setText(null);
                        message.setText(null);
                        Toast.makeText(getApplicationContext(),"successfully submitted your Inquiry ",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Submit Error,please try again",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}