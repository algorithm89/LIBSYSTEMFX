package com.example.libsystemfx;

import java.sql.*;


public class ShowBooks {

    static final String DB_URL = "jdbc:mysql://localhost/library";
    static final String USER = "root";
    static final String PASS = "gonchgx-89!!!";

    public void showBooks() {

        String sql = "SELECT * from BOOKS";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            System.out.println("Fetching records without condition...");

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //Display values
                System.out.print(rs.getString("BookID"));
                System.out.print(rs.getString("BookName"));
                System.out.println(rs.getString("BookDescription"));

            }
            rs.close();


        }catch
        (SQLException e) {

            throw new RuntimeException(e);
        }

    }
}
