package com.example.dovah.muse_hic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class PlaylistActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        Toolbar toolbarPlaylist = findViewById(R.id.status_toolbar);
        setSupportActionBar(toolbarPlaylist);

        //Add Listener for the toolbar buttons
        ImageView recentButton = findViewById(R.id.recents);
        recentButton.setOnClickListener(this);
        ImageView favouriteButton = findViewById(R.id.favourite);
        favouriteButton.setOnClickListener(this);

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

    //Explain what to do when toolbar buttons are pressed
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recents:
                Intent intentRecent = new Intent(PlaylistActivity.this, RecentActivity.class);
                startActivity(intentRecent);
                break;
            case R.id.favourite:
                Intent intentFavour = new Intent(PlaylistActivity.this, FavourActivity.class);
                startActivity(intentFavour);

        }
    }
}