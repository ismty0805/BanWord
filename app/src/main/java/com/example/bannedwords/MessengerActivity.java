package com.example.bannedwords;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
    private EditText EditText_chat;
    private ImageButton Button_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        getSupportActionBar().hide();

        chatList = ChatList.getChatList();
        Button_send = findViewById(R.id.Button_send);
        EditText_chat = findViewById(R.id.EditText_chat);

        EditText_chat.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    String msg = EditText_chat.getText().toString(); //msg
                    //널이 아닐때만 값전송하게
                    if (msg.length()!=0) {
                        ChatData chat = new ChatData();
                        chat.setMsg(msg);
                        chat.setTime();
                        chatList.add(chat);
                        mRecyclerView.setAdapter(mAdapter);
                        EditText_chat.setText("");
                    }
                    return true;
                }
                return false;
            }
        });

        Button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = EditText_chat.getText().toString(); //msg
                //널이 아닐때만 값전송하게
                if (msg.length()!=0) {
                    ChatData chat = new ChatData();
                    chat.setMsg(msg);
                    chat.setTime();
                    chatList.add(chat);
                    mRecyclerView.setAdapter(mAdapter);
                    EditText_chat.setText("");
                }

            }
        });

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //어뎁터

        mAdapter = new RecyclerViewAdapter(this, chatList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
