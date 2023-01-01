package com.example.libsystemfx;

public class Book {

    private int BookID;
    private String BookName;
    private String BookDescription;


    public Book(int bookID, String bookName, String bookDescription) {
        BookID = bookID;
        BookName = bookName;
        BookDescription = bookDescription;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookDescription() {
        return BookDescription;
    }

    public void setBookDescription(String bookDescription) {
        BookDescription = bookDescription;
    }
}
