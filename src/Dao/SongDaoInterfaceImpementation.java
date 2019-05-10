/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Song;
import utils.dbutils;

/**
 *
 * @author Makis
 */
public class SongDaoInterfaceImpementation implements SongDaoInterface{

    @Override
    public List<Song> getAllSongs() {
        Connection conn = dbutils.createConnection();
        String sql = "select * from song";
        List<Song> AllSongs = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs=null;
            rs = pst.executeQuery();
            while(rs.next()){
                Song song = new Song();
                String title = rs.getString("title");
                song.setTitle(title);                
                String artist = rs.getString("artist");
                song.setArtist(artist);
                String lyrics = rs.getString("lyrics");
                song.setLyrics(lyrics);
                String album = rs.getString("album");
                song.setAlbum(album);
                byte[] mp3file = rs.getBytes("mp3file");
                song.setMp3file(mp3file);
                int releaseyear = rs.getInt("releaseyear");
                song.setReleaseyear(releaseyear);
                AllSongs.add(song);
            }
              System.out.println("The list of songs is the below:");
              for(int i=0;i<AllSongs.size();i++){
                  System.out.println(i+1+". "+AllSongs.get(i).toString());}
            
        } catch (SQLException ex) {
            Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return AllSongs; 
    }

    @Override
    public List<Song> getSongsByTitle(String title) {
        Connection conn = dbutils.createConnection();
        String sql = "select * from song where title=?";
        List<Song> SongsByTitle = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs=null;
            pst.setString(1, title);
            rs = pst.executeQuery();
            while(rs.next()){
                Song song = new Song();
                song.setTitle(title);                
                String artist = rs.getString("artist");
                song.setArtist(artist);
                String lyrics = rs.getString("lyrics");
                song.setLyrics(lyrics);
                String album = rs.getString("album");
                song.setAlbum(album);
                byte[] mp3file = rs.getBytes("mp3file");
                song.setMp3file(mp3file);
                int releaseyear = rs.getInt("releaseyear");
                song.setReleaseyear(releaseyear);
                SongsByTitle.add(song);
            }
              System.out.println("The list of songs with the title: "+title+" is the below:");
              for(int i=0;i<SongsByTitle.size();i++){
                  System.out.println(i+1+". "+SongsByTitle.get(i).toString());}
            
        } catch (SQLException ex) {
            Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return SongsByTitle;    }

    @Override
    public List<Song> getSongsByArtist(String artist) {
        Connection conn = dbutils.createConnection();
        String sql = "select * from song where artist=?";
        List<Song> SongsByArtist = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs=null;
            pst.setString(1, artist);
            rs = pst.executeQuery();
            while(rs.next()){
                Song song = new Song();
                song.setArtist(artist);
                String title = rs.getString("title");
                song.setTitle(title);                
                String lyrics = rs.getString("lyrics");
                song.setLyrics(lyrics);
                String album = rs.getString("album");
                song.setAlbum(album);
                byte[] mp3file = rs.getBytes("mp3file");
                song.setMp3file(mp3file);
                int releaseyear = rs.getInt("releaseyear");
                song.setReleaseyear(releaseyear);
                SongsByArtist.add(song);
            }
              System.out.println("The list of songs for artist: "+artist+" is the below:");
              for(int i=0;i<SongsByArtist.size();i++){
                  System.out.println(i+1+". "+SongsByArtist.get(i).toString());}
            
        } catch (SQLException ex) {
            Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return SongsByArtist;}

    @Override
    public Song getSongById(int id) {
        Connection conn = dbutils.createConnection();
        String sql = "select * from song where id=?";
        Song song = new Song();               
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs=null;
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()){                
                String artist = rs.getString("artist");
                song.setArtist(artist);
                String title = rs.getString("title");
                song.setTitle(title);                
                String lyrics = rs.getString("lyrics");
                song.setLyrics(lyrics);
                String album = rs.getString("album");
                song.setAlbum(album);
                byte[] mp3file = rs.getBytes("mp3file");
                song.setMp3file(mp3file);
                int releaseyear = rs.getInt("releaseyear");
                song.setReleaseyear(releaseyear);
                
                System.out.println(song.toString());
        
      }
        } catch (SQLException ex) {
            Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        
    return song;}

    @Override
    public boolean insertSong(Song song) {
        
            Connection conn  =  dbutils.createConnection();
            String sql = " INSERT INTO song (artist, title, lyrics, album, mp3file, releaseyear)" +
                    "VALUES (?,?, ?, ?, ?, ? );";
            try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
                

            preparedStatement.setString(1, song.getArtist());
            preparedStatement.setString(2, song.getTitle());
            preparedStatement.setString(3, song.getLyrics());
            preparedStatement.setString(4, song.getAlbum());
            preparedStatement.setBytes(5, song.getMp3file());
            preparedStatement.setInt(6, song.getReleaseyear());
            
            preparedStatement.executeUpdate();

            //conn.close();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
        }
            finally {try {
           conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
             return true;
    }

    @Override
    public boolean deleteSong(int id) {
        Connection conn = dbutils.createConnection();
        String sql = "delete from song where id="+id;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{try {
            conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        
        

    return true;}

    @Override
    public void updateSong(Song song) {
            Connection conn = dbutils.createConnection();
            String sql = "update song set artist=?,title=?,lyrics=?,album=?,mp3file=?,releaseyear=? where id=?";
            
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, song.getArtist());
            preparedStatement.setString(3, song.getLyrics());
            preparedStatement.setString(2, song.getTitle());
            preparedStatement.setString(4, song.getAlbum());
            preparedStatement.setBytes(5, song.getMp3file());
            preparedStatement.setInt(6, song.getReleaseyear());
            preparedStatement.setInt(7, song.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{try {
            conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SongDaoInterfaceImpementation.class.getName()).log(Level.SEVERE, null, ex);
            }}
        }
    
}
