package com.mycompany.databasemanegement;

import java.sql.SQLException;
import java.util.List;

public interface DAO {

    /**
     * Create a new row in the table (create a new item)
     */
    void create(String name) throws SQLException;

    void create(String title, int releaseYear, String artistName, List<String> genreNames) throws SQLException;

    /**
     * Get the nex id for a new roe in the table
     */
    int getNextId() throws SQLException;

    /**
     * Find an item by searching for its name
     */
    Integer findByName(String name) throws SQLException;

    /**
     * Find an item by searching for its id
     */
    String findById(int id) throws SQLException;
}
