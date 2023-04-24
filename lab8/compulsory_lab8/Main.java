package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            Database.getConnection().commit();
            var albums = new AlbumDAO();

            List<String> genres1 = new ArrayList<>(); genres1.add("Rock");
            albums.create("The Wall",1979 , "Pink Floyd", genres1);

            List<String> genres2 = new ArrayList<>(); genres2.add("Funk"); genres2.add("Soul"); genres2.add("Pop");
            albums.create("Thriller",1982, "Michael Jackson",genres2);

            albums.printAllAlbums();

        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}