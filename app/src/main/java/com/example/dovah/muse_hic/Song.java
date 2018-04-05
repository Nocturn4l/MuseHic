package com.example.dovah.muse_hic;


public class Song {
    private String title;
    private String author;
    private int album_src;

    public Song(String t, String a, int img) {
        title = t;
        author = a;
        album_src = img;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAlbum_src() {
        return album_src;
    }
}
