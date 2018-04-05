package com.example.dovah.muse_hic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.ArrayList;


public class RecentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        setTitle("Last Played");

        Toolbar toolbarRecent = findViewById(R.id.status_toolbar);
        setSupportActionBar(toolbarRecent);

        //Add Listener for the toolbar buttons
        ImageView favouriteButton = findViewById(R.id.favourite);
        favouriteButton.setOnClickListener(this);
        ImageView playlistButton = findViewById(R.id.playlists);
        playlistButton.setOnClickListener(this);

        //Create and populate an array of Song Objects
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("A place Like You", "ATB, Mister Blonde", R.drawable.album_next));
        songs.add(new Song("Secrets", "The Weeknd", R.drawable.album_starboy));
        songs.add(new Song("Numb", "Linkin Park", R.drawable.album_meteora));
        songs.add(new Song("Six feet under", "The Weeknd", R.drawable.album_starboy));
        songs.add(new Song("Farewell To The Fairground", "White Lies", R.drawable.album_tolose));
        songs.add(new Song("Breach", "ATB, Myon, Ethan Thompson", R.drawable.album_next));
        songs.add(new Song("Track 17", "Unkown", R.drawable.album_standard));
        songs.add(new Song("Pages", "ATB, HALIENE", R.drawable.album_next));
        songs.add(new Song("audio_file_13", "Unkown", R.drawable.album_standard));
        songs.add(new Song("Breaking The Habit", "Linkin park", R.drawable.album_meteora));
        songs.add(new Song("Recorded_files_1", "Unkown", R.drawable.album_standard));
        songs.add(new Song("Somewhere I Belong", "Linkin Park", R.drawable.album_meteora));
        songs.add(new Song("Party Monster", "The Weeknd", R.drawable.album_starboy));
        songs.add(new Song("To lose my life", "White Lies", R.drawable.album_tolose));


        //Create and set the Adapter in a ListView
        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listV = findViewById(R.id.list);
        listV.setAdapter(adapter);

        /*Set a ClickListener on every Item list to play the selected song
        And pass the information of the relative Song with putExtra method*/
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Song listItem = (Song) parent.getItemAtPosition(position);
                String title = listItem.getTitle();
                String author = listItem.getAuthor();
                int album = listItem.getAlbum_src();
                Intent playerIntent = new Intent(RecentActivity.this, PlayerActivity.class);
                playerIntent.putExtra("int_value", album);
                playerIntent.putExtra("String_title", title);
                playerIntent.putExtra("String_author", author);
                startActivity(playerIntent);
            }
        });


    }

    //Explain what to do when toolbar buttons are pressed
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.favourite:
                Intent intentFavour = new Intent(RecentActivity.this, FavourActivity.class);
                startActivity(intentFavour);
                break;
            case R.id.playlists:
                Intent intentPlaylist = new Intent(RecentActivity.this, PlaylistActivity.class);
                startActivity(intentPlaylist);

        }
    }
}
