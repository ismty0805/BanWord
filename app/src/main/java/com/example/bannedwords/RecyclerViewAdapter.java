package com.example.bannedwords;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        String text = chatDataArrayList.get(position).getMsg();
        String banWord = BanWords.inBanWords(text);
        if(banWord!=null){
            String[] substring = text.split(banWord);
            Log.d("len", ""+substring.length);
            if(substring.length == 0){
                substring = new String[2];
                substring[0] = "";
                substring[1] = "";
            }else if(substring.length==1){
                String temp = substring[0];
                substring = new String[2];
                if(text.indexOf(temp)<text.indexOf(banWord)){
                    substring[0] = temp;
                    substring[1] = "";
                }else{
                    substring[0] = "";
                    substring[1] = temp;
                }

            }
            holder.msg.setText(substring[0]);
            holder.msg3.setText(substring[1]);
            holder.msg3.setVisibility(View.VISIBLE);
            holder.msg2.setText(banWord);
            holder.msg2.setVisibility(View.VISIBLE);
            holder.msg2.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            );
            holder.msg2.layout(0, 0, holder.msg2.getMeasuredWidth(), holder.msg2.getMeasuredHeight());
            holder.msg2.buildDrawingCache();;

            Bitmap bitmap = Bitmap.createScaledBitmap(holder.msg2.getDrawingCache(), holder.msg2.getDrawingCache().getWidth(), holder.msg2.getDrawingCache().getHeight(), false);
            Bitmap temp = Bitmap.createScaledBitmap(bitmap, 5, 5, false);
            Bitmap mosaicBitmap = Bitmap.createScaledBitmap(temp, bitmap.getWidth(), bitmap.getHeight(), false);
            holder.mosaic.setImageBitmap(mosaicBitmap);
            holder.mosaic.setVisibility(View.VISIBLE);
            holder.msg2.setVisibility(View.GONE);

        }else {
            holder.msg.setText(chatDataArrayList.get(position).getMsg());
        }
        Log.d("ok", "banned");

    }

    @Override
    public int getItemCount() {
        return chatDataArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView time;
        TextView msg;
        TextView msg2;
        ImageView mosaic;
        TextView msg3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.TextView_time);
            msg = itemView.findViewById(R.id.TextView_msg);
            msg2 = itemView.findViewById(R.id.TextView_msg2);
            msg3 = itemView.findViewById(R.id.TextView_msg3);
            mosaic = itemView.findViewById(R.id.TextView_msg_mosaic);
        }
    }

}
