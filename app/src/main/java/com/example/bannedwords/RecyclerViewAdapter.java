package com.example.bannedwords;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<ChatData> chatDataArrayList;

    public RecyclerViewAdapter(Context ctx, ArrayList<ChatData> chatDataArrayList) {
        inflater = LayoutInflater.from(ctx);
        this.chatDataArrayList = chatDataArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_chat, parent, false);
        MyViewHolder holder = new MyViewHolder(view) {
        };
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.time.setText(chatDataArrayList.get(position).getTime());
        holder.msg.setText(chatDataArrayList.get(position).getMsg());
    }

    @Override
    public int getItemCount() {
        return chatDataArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView time;
        TextView msg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.TextView_time);
            msg = itemView.findViewById(R.id.TextView_msg);
        }
    }
}
