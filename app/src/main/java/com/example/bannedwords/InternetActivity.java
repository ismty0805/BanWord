package com.example.bannedwords;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InternetActivity extends AppCompatActivity {
    private TextView textView1;
    private ImageView imageView1;
    private TextView textView2;
    private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        textView1 = findViewById(R.id.textview1);
        imageView1 = findViewById(R.id.imageview1);
        textView2 = findViewById(R.id.textview2);
        textView3 = findViewById(R.id.textview3);

        String text = textView1.getText().toString();
        if(text.contains("ban")){
            String[] substring = text.split("ban");
            textView1.setText(substring[0]);
            textView2.setText(substring[1]);
            textView2.setVisibility(View.VISIBLE);

            textView3.setText("ban");
            textView3.setVisibility(View.VISIBLE);
            textView3.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            );
            textView3.layout(0, 0, textView3.getMeasuredWidth(), textView3.getMeasuredHeight());
            textView3.buildDrawingCache();;

            Bitmap bitmap = Bitmap.createScaledBitmap(textView3.getDrawingCache(), textView3.getDrawingCache().getWidth(), textView3.getDrawingCache().getHeight(), false);
            Bitmap temp = Bitmap.createScaledBitmap(bitmap, 5, 5, false);
            Bitmap mosaicBitmap = Bitmap.createScaledBitmap(temp, bitmap.getWidth(), bitmap.getHeight(), false);
            imageView1.setImageBitmap(mosaicBitmap);
//            imageView1.setImageBitmap(bitmap);
            imageView1.setVisibility(View.VISIBLE);
//            textView3.setText("");
            textView3.setVisibility(View.GONE);


        }
    }
}