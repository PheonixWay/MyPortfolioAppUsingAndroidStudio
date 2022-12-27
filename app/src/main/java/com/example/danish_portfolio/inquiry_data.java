package com.example.danish_portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class inquiry_data extends AppCompatActivity {
    RecyclerView r_view;
    DatabaseReference database;
    inquiry_data_adapter inquiry_data_adapter_variable;
    ArrayList<inquiry_save_data> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry_data);
        r_view=findViewById(R.id.rcv_id);

        r_view.setLayoutManager(new LinearLayoutManager(this));
        database= FirebaseDatabase.getInstance().getReference("inquiry");
        r_view.setHasFixedSize(true);

        list=new ArrayList<>();
        inquiry_data_adapter_variable=new inquiry_data_adapter(this,list);
        r_view.setAdapter(inquiry_data_adapter_variable);

        database.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    inquiry_save_data save_data_object=dataSnapshot.getValue(inquiry_save_data.class);
                    list.add(save_data_object);

                }

                inquiry_data_adapter_variable.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}