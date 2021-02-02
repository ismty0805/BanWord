package com.example.bannedwords;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button add;
    private ImageButton messenger;
    private TextView words;
    private TextView wordsTitle;
    private Button see;
    private ImageButton digitalWellbeing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        messenger =findViewById(R.id.messenger);
        add = findViewById(R.id.add);
        words = findViewById(R.id.banWords);
        see = findViewById(R.id.seeBanWords);
        wordsTitle = findViewById(R.id.banWordsTitle);
        digitalWellbeing = findViewById(R.id.digitalWellbeing);

        messenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessengerActivity.class);
                startActivity(intent);
            }
        });
        digitalWellbeing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DigitalWellbeingActivity.class);
                startActivity(intent);
            }
        });
    }

}