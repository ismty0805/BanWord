package com.example.bannedwords;

import java.util.ArrayList;

public class ChatList {
    private static ArrayList<ChatData> chatList = new ArrayList<>();

    public static ArrayList<ChatData> getChatList() {
        return chatList;
    }

    public void setChatList(ArrayList<ChatData> chatList) {
        this.chatList = chatList;
    }
}
