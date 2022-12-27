package com.example.danish_portfolio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class inquiry_data_adapter extends RecyclerView.Adapter<inquiry_data_adapter.holder>
{

    Context context;
    ArrayList<inquiry_save_data> list;

    public inquiry_data_adapter(Context context, ArrayList<inquiry_save_data> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.template_for_inquiry_data_read,parent,false);
        return new holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position)
    {
        inquiry_save_data savedata=list.get(position);
        holder.name_in_holder.setText(savedata.getName());
        holder.email_in_holder.setText(savedata.getEmail());
        holder.number_in_holder.setText(savedata.getNumber());
        holder.message_in_holder.setText(savedata.getMessage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class holder extends RecyclerView.ViewHolder
    {
        TextView name_in_holder,email_in_holder,number_in_holder,message_in_holder;
        public holder(@NonNull View itemView) {
            super(itemView);
            name_in_holder=itemView.findViewById(R.id.inquiry_data_name_id);
            email_in_holder=itemView.findViewById(R.id.inquiry_data_email_id);
            number_in_holder=itemView.findViewById(R.id.inquiry_data_number_id);
            message_in_holder=itemView.findViewById(R.id.inquiry_data_message_id);
        }
    }
}
