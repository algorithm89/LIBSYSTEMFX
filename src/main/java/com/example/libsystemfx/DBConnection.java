package com.example.libsystemfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection DBCONN()
    {

        Connection conn = null;


        try {

            final String DB_URL = "jdbc:mysql://localhost/library";
            final String USER = "root";
            final String PASS = "gonchgx-89!!!";

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        }catch
        (SQLException e) {

            throw new RuntimeException(e);
        }



        return conn;


    }

}
