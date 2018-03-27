package com.example.dovah.muse_hic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class PlaylistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Add Listener for the toolbar buttons
        //#1 Favourites Buttons
        ImageView favour = findViewById(R.id.favourite);
        favour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlaylistActivity.this, FavourActivity.class);
                startActivity(i);
            }
        });
        //#2 Recent Button
        ImageView recent = findViewById(R.id.recents);
        recent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlaylistActivity.this, RecentActivity.class);
                startActivity(i);
            }
        });

        //Create and populate an array of Song Objects
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("Hip-Pop Songs");
        playlist.add("Christmas Songs");
        playlist.add("2018 Playlist");
        playlist.add("90 Greatest Hits");

        //Create and set the Adapter in a ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playlist);
        ListView listV = findViewById(R.id.list);
        listV.setAdapter(adapter);

    }
}