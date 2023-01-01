package com.example.libsystemfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ActionBookController implements Initializable {

    private Connection con = null;
    private PreparedStatement pst =null;
    private ResultSet rs = null;
    @FXML
    Button AddBooks;

    @FXML
    Button DelBook;

    @FXML
    TextField textField1;

    @FXML
    TextArea textField2;

    @FXML
    TextField textField3;

    @FXML
    Label label1;




    @FXML
    protected void AddBook(ActionEvent event) throws Exception, SQLException
    {
        String sql = "INSERT into books (BookName,BookDescription) VALUES(?,?)";

        String txtfield1 = textField1.getText();
        String txtfield2 = textField2.getText();

        try
            {
                pst = con.prepareStatement(sql);
                pst.setString(1,txtfield1);
                pst.setString(2,txtfield2);
                int i = pst.executeUpdate();

                if (i ==1)
                {
                    System.out.println("Data Inserted Succesffully");

                }

            }
            catch (SQLException SQL){
                SQL.printStackTrace();
            ;}

        pst.close();
    }

    @FXML
    protected void DelBooks(ActionEvent event) throws SQLException {

        String sql = "DELETE FROM books WHERE BookID= ?";

        int ID = Integer.parseInt(textField3.getText());

        try
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1,ID);

            int i = pst.executeUpdate();

            if ( i > 0)
            {
                System.out.println("Data Deleted Succesffully");

            }else
                System.out.println("Record not found.");

        }
        catch (SQLException SQL){
            SQL.printStackTrace();
            ;}

        pst.close();



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         con = DBConnection.DBCONN();
    }
}
