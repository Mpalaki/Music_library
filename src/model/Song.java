/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.Year;

/**
 *
 * @author Makis
 */
public class Song {
     private int id;
    private String artist;
    private String title;
    private String lyrics;
    private String album;
    private byte[] mp3file;
    private int releaseyear; //read the docs https://docs.oracle.com/javase/8/docs/api/java/time/Year.html

    public Song() {
    }

    public int getId() {
        return id;
    }

    public Song(int id, String artist, String title, String lyrics, String album, byte[] mp3file, int releaseyear) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.lyrics = lyrics;
        this.album = album;
        this.mp3file = mp3file;
        this.releaseyear = releaseyear;
    }

    public Song(String artist, String title, String lyrics, String album, byte[] mp3file, int releaseyear) {
        this.artist = artist;
        this.title = title;
        this.lyrics = lyrics;
        this.album = album;
        this.mp3file = mp3file;
        this.releaseyear = releaseyear;
    }

    public Song(int id, String artist, String title, String lyrics, String album,  int releaseyear) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.lyrics = lyrics;
        this.album = album;
        this.releaseyear = releaseyear;
    }

    public Song(String artist, String title, String lyrics, String album, int releaseyear) {
        this.artist = artist;
        this.title = title;
        this.lyrics = lyrics;
        this.album = album;
        this.releaseyear = releaseyear;
    }

    public Song(String artist, String title, String lyrics, String album) {
        this.artist = artist;
        this.title = title;
        this.lyrics = lyrics;
        this.album = album;
    }

    
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public byte[] getMp3file() {
        return mp3file;
    }

    public void setMp3file(byte[] mp3file) {
        this.mp3file = mp3file;
    }

    public int getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(int releaseyear) {
        this.releaseyear = releaseyear;
    }

    @Override
    public String toString() {
        return "Song{" +  " artist=" + artist + ", title=" + title + ", lyrics=" + lyrics + ", album=" + album + ", mp3file=" + mp3file + ", releaseyear=" + releaseyear + '}';
    }
    
    
}
