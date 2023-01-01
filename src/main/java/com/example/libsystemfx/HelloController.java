package com.example.libsystemfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private Connection con = null;
    private PreparedStatement pst =null;
    private ResultSet rs = null;
    private ObservableList<Book> data;

    @FXML
    private TableView<Book> Books;
    @FXML
    private TableColumn<Book, String> ID;
    @FXML
    private TableColumn<Book, String>  BookName;
    @FXML
    private TableColumn<Book, String> BookDescription;

    @FXML
    protected void ViewTable(ActionEvent event) throws SQLException {
        data.clear();
        SetCellTable();
        try {
            LoadDatafromDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    Button button;

    @FXML
     void AddBook(ActionEvent event) throws SQLException, IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BookAdd.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("AddBooks");
            stage.setScene(new Scene(root));
            stage.show();

        }  catch (IOException e)
                 {
                    e.printStackTrace();
                 }
    }

    private void SetCellTable()
    {
        ID.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        BookName.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        BookDescription.setCellValueFactory(new PropertyValueFactory<>("BookDescription"));

    }


    private void LoadDatafromDatabase() throws SQLException
    {
        try {
            pst = con.prepareStatement("SELECT * from BOOKS");
            rs = pst.executeQuery();

            while (rs.next())
            {

            data.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Books.setItems(data);

    };


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            con = DBConnection.DBCONN();

            data = FXCollections.observableArrayList();

    }
}