package com.example.dovah.muse_hic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Activity context, ArrayList<Song> wordArrayList) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, wordArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID
        TextView titleTextView = listItemView.findViewById(R.id.songname);
        // Get the version name from the current WordAdapter object and
        // set this text on the name TextView
        titleTextView.setText(currentSong.getTitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView authorTextView = listItemView.findViewById(R.id.authorname);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        authorTextView.setText(currentSong.getAuthor());

        ImageView albumImageView = listItemView.findViewById(R.id.albumsrc);

        albumImageView.setImageResource(currentSong.getAlbum_src());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }


}
