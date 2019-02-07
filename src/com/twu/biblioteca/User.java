package com.twu.biblioteca;

import java.util.LinkedList;

public class User {

    private String name;
    private String email;
    private String phoneNumber;
    private String libraryNumber;
    private String password;
    private LinkedList<Book> bookList;

    public User(String name, String email, String phoneNumber,
                String libraryNumber, String password, LinkedList<Book> bookList){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.bookList = bookList;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public String getPassword(){
        return this.password;
    }

    public LinkedList<Book> getBookList(){
        return this.bookList;
    }

    public void showBooks(){
        System.out.println("Checked Out Books:");
        for (int i = 0; i <= this.bookList.size() - 1; i++){
            System.out.println(this.bookList.get(i).getTitle());
        }
    }
}
