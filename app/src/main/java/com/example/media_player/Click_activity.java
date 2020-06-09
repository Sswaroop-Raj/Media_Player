package com.example.media_player;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Click_activity extends AppCompatActivity {
    TextView lyrics, textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_activity);

        lyrics = findViewById(R.id.lyrics);
        textView = findViewById(R.id.textView2);
    }
}

