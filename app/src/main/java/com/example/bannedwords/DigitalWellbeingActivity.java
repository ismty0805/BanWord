package com.example.bannedwords;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DigitalWellbeingActivity extends AppCompatActivity {
    private Button add;
    private TextView words;
    private TextView wordsTitle;
    private Button see;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_wellbeing);

        getSupportActionBar().hide();

        add = findViewById(R.id.add);
        words = findViewById(R.id.banWords);
        see = findViewById(R.id.seeBanWords);
        wordsTitle = findViewById(R.id.banWordsTitle);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newWord = new EditText(DigitalWellbeingActivity.this);

                AlertDialog.Builder builder = new AlertDialog.Builder(DigitalWellbeingActivity.this);
                builder.setTitle("금지어 추가");
                builder.setView(newWord);
                builder.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String word = newWord.getText().toString();
                                BanWords.addBanWord(word);
                                refreshWords();
                            }
                        });
                builder.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
            }
        });
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                see.setVisibility(View.GONE);
                words.setVisibility(View.VISIBLE);
                wordsTitle.setVisibility(View.VISIBLE);

            }
        });

        BanWords.addBanWord("나쁜말");
        BanWords.addBanWord("ㅗ");
        refreshWords();
    }

    private void refreshWords(){
        ArrayList<String> banWords = BanWords.getBanWords();
        String s = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            s = String.join(", ", banWords);
        }
        words.setText(s);
    }
}