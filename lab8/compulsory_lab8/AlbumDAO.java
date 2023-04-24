package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    public void create(String title, int releaseYear, String artistName, List<String> genreNames) throws SQLException {
        Connection con = Database.getConnection();
        Integer artistId = new ArtistDAO().findByName(artistName);
        if (artistId == null) {
            new ArtistDAO().create(artistName);
            artistId = new ArtistDAO().findByName(artistName);
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (title, release_year, artist_id) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, releaseYear);
            pstmt.setInt(3, artistId);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int albumId = rs.getInt(1);
            for (String genreName : genreNames) {
                Integer genreId = new GenreDAO().findByName(genreName);
                if (genreId == null) {
                    new GenreDAO().create(genreName);
                    genreId = new GenreDAO().findByName(genreName);
                }
                try (PreparedStatement pstmt2 = con.prepareStatement(
                        "insert into album_genres (album_id, genre_id) values (?, ?)")) {
                    pstmt2.setInt(1, albumId);
                    pstmt2.setInt(2, genreId);
                    pstmt2.executeUpdate();
                }
            }
            con.commit();
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
                String genres = rs.getString("genres");
                System.out.println(id + ", " + year + ", " + title + ", " + artist + ", " + genres);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.closeConnection();
        }
    }
}
