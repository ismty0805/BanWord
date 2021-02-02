package com.example.bannedwords;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChatData{

    private String msg;
    private String nickname;
    private String time;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setTime(){
        SimpleDateFormat format = new SimpleDateFormat("aa hh:mm");
        Calendar date = Calendar.getInstance();
        this.time = format.format(date.getTime());
    }

    public String getTime(){return time;}


}
