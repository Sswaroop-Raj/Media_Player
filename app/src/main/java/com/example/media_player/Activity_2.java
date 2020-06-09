package com.example.media_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.File;
import java.util.ArrayList;

public class Activity_2 extends AppCompatActivity implements View.OnClickListener {
    Button play, pause, stop,button,btn_back;
    MediaPlayer media_player;
    SeekBar seekbar;
    int pausePosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        /*Bundle bundle = getIntent().getExtras();
        bundle.getStringArrayList("SongName");*/

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        /*bundle = getIntent().getExtras();
        ArrayList<String>new_list = bundle.getStringArrayList("list");*/

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        seekbar = findViewById(R.id.my_seekbar);
        button = findViewById(R.id.btn);
        btn_back = findViewById(R.id.back);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener((View.OnClickListener) this);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_2.this,MainActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_2.this,Click_activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (media_player == null) {
                    media_player = MediaPlayer.create(getApplicationContext(), R.raw.do_or_die);
                    media_player.start();
                } else if (!media_player.isPlaying()) {
                    media_player.seekTo(pausePosition);
                    media_player.start();
                }
                break;
            case R.id.pause:
                if (media_player != null) {
                    media_player.pause();
                    pausePosition = media_player.getCurrentPosition();

                }
                break;
            case R.id.stop:
                if (media_player != null) {
                    media_player.stop();

                }
                break;

        }
    }


}
