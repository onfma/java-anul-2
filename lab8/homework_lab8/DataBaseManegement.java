package com.mycompany.databasemanegement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManegement {

   public static void main(String args[]) {
        try {
            var artists = new ArtistDAO();
            var genres = new GenreDAO();
            var albums = new AlbumDAO();

            genres.create("Soul");
            artists.create("112222");
            genres.create("Rock");
            artists.create("Pink Floyd");
            genres.create("Funk");
            genres.create("Pop");
            artists.create("Michael Jackson");
            artists.create("112222dddd");
            genres.create("LoFi");

            List<String> genres1 = new ArrayList<>(); genres1.add("Rock");
            List<String> genres2 = new ArrayList<>(); genres2.add("Funk"); genres2.add("Soul"); genres2.add("Pop");
            //albums.create("aabbb",1985, "112222",genres2);
            //albums.create("The Wall3",1979 , "Pink Floyd", genres1);
            albums.create("Thriller",1982, "Michael Jackson",genres2);
            //albums.create("you",1982, "Michael Jackson",genres1);
            //albums.create("you",1982, "Michael Jackson",genres1);


            //albums.printAllAlbums();


            /*List<String> genres1 = new ArrayList<>(); genres1.add("Rock");
            List<String> genres2 = new ArrayList<>(); genres2.add("Funk"); genres2.add("Soul"); genres2.add("Pop");
            albums.create("aab",1985, "112222",genres2);
            albums.create("The Wall",1979 , "Pink Floyd", genres1);
            albums.create("Thriller",1982, "Michael Jackson",genres2);
            albums.create("you",1982, "Michael Jackson",genres1);
            albums.create("you",1982, "Michael Jackson",genres1);*/
        }
        catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
