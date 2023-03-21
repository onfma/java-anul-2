package org.example;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.example.Admin.save;

public class Main {
    public static void main(String[] args)
    {
        Catalog catalog = new Catalog("catalog");
        var book = new Document("carte", "autor", ".." );
        var article = new Document("articol", "autor", ".." );
        catalog.addDocument(book);
        catalog.addDocument(article);

        try {
            save(catalog, "C:/Users/Maria/Desktop/catalog.json");
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        try{
            Catalog catalog2 = Admin.load("C:/Users/Maria/Desktop/catalog.json");
        }catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, "NU MERGE LOAD", ex);
        }
    }
}