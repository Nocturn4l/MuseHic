package com.example.dovah.muse_hic;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);

        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        Toolbar toolbarPlayer = findViewById(R.id.player_toolbar);
        setSupportActionBar(toolbarPlayer);
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();

        TextView info_tv = findViewById(R.id.song_info);
        String song_info = intent.getStringExtra("String_title");
        song_info = song_info + " - " + intent.getStringExtra("String_author");
        info_tv.setText(song_info);
        info_tv.setSelected(true);



      /* Recover the album of current song and set it on layout*/
        ImageView cover_iv = findViewById(R.id.album_playing);
        int id_cover = intent.getIntExtra("int_value", 0);
        cover_iv.setImageResource(id_cover);


    }
}