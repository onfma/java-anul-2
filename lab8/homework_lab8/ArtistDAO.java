package com.mycompany.databasemanegement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;

public class ArtistDAO implements DAO{

    public void create(String title, int releaseYear, String artistName, List<String> genreNames) throws SQLException{}
    public void create(String name) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "insert into artists (id, name) values (?, ?)")) {
            pstmt.setInt(1, getNextId());
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("Created artist " + name);
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("The artist already exists: " + name);
        }
        catch (SQLException e) {
            System.out.println("Error creating genre: " + e.getMessage());
            throw e;
        }
    }

    public int getNextId() throws SQLException {
        try (Connection con = Database.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select max(id) from artists")) {
            if (rs.next()) {
                return rs.getInt(1) + 1;
            } else {
                return 1;
            }
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }

    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
