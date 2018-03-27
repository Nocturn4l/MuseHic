package com.example.dovah.muse_hic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class FavourActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Add Listener for the toolbar buttons
        //#1 Recent Buttons
        ImageView recent = findViewById(R.id.recents);
        recent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FavourActivity.this, RecentActivity.class);
                startActivity(i);
            }
        });
        //#2 Playlist Button
        ImageView playlist = findViewById(R.id.playlists);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FavourActivity.this, PlaylistActivity.class);
                startActivity(i);
            }
        });

        //Create and populate an array of Song Objects
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Numb", "Linkin Park", R.drawable.album_meteora));
        songs.add(new Song("Six feet under", "The Weeknd", R.drawable.album_starboy));
        songs.add(new Song("Farewell To The Fairground", "White Lies", R.drawable.album_tolose));
        songs.add(new Song("Breach", "ATB, Myon, Ethan Thompson", R.drawable.album_next));


        //Create and set the Adapter in a ListView
        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listV = findViewById(R.id.list);
        listV.setAdapter(adapter);

        //Set a ClickListener on every Item list to play the selected song
        //And pass the information of the relative Song with putExtra method
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Song listItem = (Song) parent.getItemAtPosition(position);
                String title = listItem.getTitle();
                String author = listItem.getAuthor();
                int album = listItem.getAlbum_src();
                Intent i = new Intent(FavourActivity.this, PlayerActivity.class);
                i.putExtra("int_value", album);
                i.putExtra("String_title", title);
                i.putExtra("String_author", author);
                startActivity(i);
            }
        });
    }
}
