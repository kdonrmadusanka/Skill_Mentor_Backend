package com.skillmentor.root.util;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnection {
    private final String url = "jdbc:mysql://localhost:3306/studentdb";
    private final String username = "kdrm";
    private final String password = "457845";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
