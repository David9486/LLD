package org.example.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getConnection() throws SQLException {

        try{

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);

        }

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/lmd","postgres","root");

    }

}
