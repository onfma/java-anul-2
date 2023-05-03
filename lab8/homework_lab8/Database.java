package com.mycompany.databasemanegement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "JAVA";
    private static final String PASSWORD = "JAVA";
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        dataSource = new HikariDataSource(config);
    }

    private Database() {}

    public static void closeConnection() {
        try {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void rollback() {
        try {
            if (getConnection() != null) {
                getConnection().rollback();
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }
}
