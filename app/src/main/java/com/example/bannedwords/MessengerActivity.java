package com.example.bannedwords;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessengerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ChatData> chatList;
    private String nick = "nick2"; // 1:1 or 1:da로

    private EditText EditText_chat;
    private Button Button_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        chatList = new ArrayList<>();
        Button_send = findViewById(R.id.Button_send);
        EditText_chat = findViewById(R.id.EditText_chat);

        Button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = EditText_chat.getText().toString(); //msg
                //널이 아닐때만 값전송하게
                if (msg != null) {
                    ChatData chat = new ChatData();
                    chat.setNickname(nick);
                    chat.setMsg(msg);
                    chat.setTime();
                    chatList.add(chat);
                    mRecyclerView.setAdapter(mAdapter);
                    EditText_chat.setText("");
                }

            }
        });

        ChatData chat = new ChatData();
        chat.setNickname(nick);
        chat.setMsg("hi");
        chat.setTime();
        chatList.add(chat);

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //어뎁터

        mAdapter = new RecyclerViewAdapter(this, chatList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
