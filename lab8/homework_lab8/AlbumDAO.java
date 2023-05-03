package com.mycompany.databasemanegement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO implements DAO{

    public void create(String name) throws SQLException{}
    public void create(String title, int releaseYear, String artistName, List<String> genreNames) throws SQLException {
        Integer artistId = new ArtistDAO().findByName(artistName);
        if (artistId == null) {
            new ArtistDAO().create(artistName);
            artistId = new ArtistDAO().findByName(artistName);
        }
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "insert into albums (id, release_year, title, artist) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, getNextIdAlbums());
            pstmt.setInt(2, releaseYear);
            pstmt.setString(3, title);
            pstmt.setString(4, artistName);
            pstmt.executeUpdate();
            for (String genreName : genreNames) {
                Integer genreId = new GenreDAO().findByName(genreName);
                if (genreId == null) {
                    new GenreDAO().create(genreName);
                    genreId = new GenreDAO().findByName(genreName);
                }
                System.out.println(genreName + " " + genreId);

                try (Connection con2 = Database.getConnection();
                     PreparedStatement pstmt2 = con2.prepareStatement(
                        "insert into album_genres (album_id, genre_id) values (?, ?)")) {
                    pstmt2.setInt(1, getNextIdAlbums()-1);
                    pstmt2.setInt(2, genreId);
                    pstmt2.executeUpdate();
                }
                catch (SQLException e) {
                    System.out.println("Error album genres: " + e.getMessage());
                }

            }
            //con.commit();
            System.out.println("Created album " + title);
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("The album already exists: " + title);

        }
        catch (SQLException e) {
            System.out.println("Error creating album: " + e.getMessage());
        }
    }


    private int getNextIdAlbums() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select max(id) from albums")) {
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
            else {
                return 1;
            }
        }
    }

    public int getNextId() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select max(id) from album_genres")) {
            if (rs.next()) {
                return rs.getInt(1) + 1;
            } else {
                return 1;
            }
        }
    }

    public Integer findByName(String name) throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from albums where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public List<String> findByArtist(String artistName) throws SQLException {
        Connection con = Database.getConnection();
        List<String> albums = new ArrayList<>();
        Integer artistId = new ArtistDAO().findByName(artistName);
        if (artistId != null) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select title from albums where artist_id=" + artistId)) {
                while (rs.next()) {
                    albums.add(rs.getString(1));
                }
            }
        }
        return albums;
    }

    public List<String> findByGenre(String genreName) throws SQLException {
        Connection con = Database.getConnection();
        List<String> albums = new ArrayList<>();
        Integer genreId = new GenreDAO().findByName(genreName);
        if (genreId != null) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select title from albums inner join album_genres on albums.id=album_genres.album_id where album_genres.genre_id=" + genreId)) {
                while (rs.next()) {
                    albums.add(rs.getString(1));
                }
            }
        }
        return albums;
    }

    public void printAllAlbums(){
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM albums");
            while (rs.next()) {
                int id = rs.getInt("id");
                int year = rs.getInt("release_year");
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                /*String genres = rs.getString("genres");*/
                System.out.println(id + ", " + year + ", " + title + ", " + artist /*+ ", " + genres*/);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.closeConnection();
        }
    }
    
}
