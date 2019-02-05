package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String yearPublished;
    private boolean checkedOut;

    public Book(String title, String author, String yearPublished, boolean checkedOut){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = checkedOut;
    }

    public void setCheckedOut(boolean checkedOut){
        this.checkedOut = checkedOut;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getYearPublished(){
        return this.yearPublished;
    }

    public boolean getCheckedOut(){
        return this.checkedOut;
    }
}
