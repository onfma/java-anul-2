package org.example;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Admin {

    /**
     * Add a document in a catalog
     */
    public static void add(Catalog catalog, Document document){catalog.addDocument(document);}

    /**
     * Save a catalog as a FILE at the location indicated by the path
     */
    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog
        );
    }

    /**
     * Loads the catalog from an external file
     */
    public static Catalog load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(path),
                Catalog.class);
    }
}
