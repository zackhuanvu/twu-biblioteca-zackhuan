package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.Scanner;

public class BibliotecaApp {

    public static LinkedList<Book> bookList = new LinkedList<>();
    public static LinkedList<Movie> movieList = new LinkedList<>();
    public static LinkedList<User> userList = new LinkedList<>();

    public static void bookSetup(){
        bookList.add(new Book("Harry Potter", "Rowling", "1997", false));
        bookList.add(new Book("The Little Prince", "Saint-Exuper", "1943", false));
        bookList.add(new Book("The Lord of the Rings", "Tolkien", "1954", false));
        bookList.add(new Book("A Tale of Two Cities", "Dickens", "1859", false));
        bookList.add(new Book("Don Quixote", "Cervantes", "1612", false));
    }

    public static void movieSetup(){
        movieList.add(new Movie ("Avatar", "2009", "Cameron", "8", false));
        movieList.add(new Movie ("Titanic", "1997", "Cameron", "10", false));
        movieList.add(new Movie ("Star Wars", "2015", "Abrams", "9", false));
        movieList.add(new Movie ("Avengers", "2018", "Russo", "Unrated", false));
    }

    public static void userSetup(){
        userList.add(new User("Zack Huan", "zack.huan@thoughtworks.com", "7188855988",
                "885-5988", "password", new LinkedList<>()));
    }

    public static String authenticateUser(Scanner sc){
        System.out.println("Please enter your library number in the format xxx-xxxx");
        String libraryNumber = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        boolean matchFound = false;
        for (int i = 0; i <= userList.size() - 1; i++){
            if (libraryNumber.equals(userList.get(i).getLibraryNumber())
                    && password.equals(userList.get(i).getPassword())){
                matchFound = true;
            }
        }
        if (!matchFound){
            return "";
        }
        return libraryNumber;
    }

    public static void displayUser(String libraryNumber){
        for (int i = 0; i <= userList.size() - 1; i++){
            if (userList.get(i).getLibraryNumber().equals(libraryNumber)){
                System.out.println("NAME: " + userList.get(i).getName());
                System.out.println("EMAIL: " + userList.get(i).getEmail());
                System.out.println("PHONE NUMBER: " + userList.get(i).getPhoneNumber());
                userList.get(i).showBooks();
            }
        }
    }

    public static void printMenu(){
        System.out.println("Main Menu of Options");
        System.out.println("(1) View a List of Books");
        System.out.println("(2) Checkout a Book");
        System.out.println("(3) Return a Book");
        System.out.println("(4) View a List of Movies");
        System.out.println("(5) Checkout a Movie");
        System.out.println("(6) Display User Information");
        System.out.println("(7) Quit the Application");
    }

    public static void showAvailableBooks(){
        for (int i = 0; i <= bookList.size()-1; i++){
            if (!bookList.get(i).getCheckedOut()){
                System.out.print(bookList.get(i).getTitle());
                System.out.print("  |  ");
                System.out.print(bookList.get(i).getAuthor());
                System.out.print("  |  ");
                System.out.println(bookList.get(i).getYearPublished());
            }
        }
    }

    public static void showAvailableMovies(){
        for (int i = 0; i <= movieList.size()-1; i++){
            if (!movieList.get(i).getCheckedOut()){
                System.out.print(movieList.get(i).getName());
                System.out.print("  |  ");
                System.out.print(movieList.get(i).getYear());
                System.out.print("  |  ");
                System.out.print(movieList.get(i).getDirector());
                System.out.print("  |  ");
                System.out.println(movieList.get(i).getRating());
            }
        }
    }

    public static void checkoutBook(Scanner sc, String libraryNumber){
        System.out.println("Please enter the title of the book to checkout:");
        String userInput = sc.nextLine();
        boolean matchFound = false;
        for (int i = 0; i <= bookList.size() - 1; i++){
            if (userInput.trim().equals(bookList.get(i).getTitle()) && !bookList.get(i).getCheckedOut()){
                bookList.get(i).setCheckedOut(true);
                for (int j = 0; j <= userList.size() - 1; j++){
                    if (userList.get(j).getLibraryNumber().equals(libraryNumber)){
                        userList.get(j).getBookList().add(bookList.get(i));
                    }
                }
                System.out.println("Thank you! Enjoy the book");
                matchFound = true;
            }
        }
        if(!matchFound){
            System.out.println("Sorry, that book is not available");
        }
    }

    public static void checkoutMovie(Scanner sc){
        System.out.println("Please enter the title of the movie to checkout:");
        String userInput = sc.nextLine();
        boolean matchFound = false;
        for (int i = 0; i <= movieList.size() - 1; i++){
            if (userInput.trim().equals(movieList.get(i).getName()) && !movieList.get(i).getCheckedOut()){
                movieList.get(i).setCheckedOut(true);
                System.out.println("Thank you! Enjoy the movie");
                matchFound = true;
            }
        }
        if(!matchFound){
            System.out.println("Sorry, that movie is not available");
        }
    }

    public static void returnBook(Scanner sc, String libraryNumber){
        System.out.println("Please enter the title of the book to return:");
        String userInput = sc.nextLine();
        boolean matchFound = false;
        for (int i = 0; i <= bookList.size() - 1; i++){
            if (userInput.trim().equals(bookList.get(i).getTitle()) && bookList.get(i).getCheckedOut()){
                bookList.get(i).setCheckedOut(false);
                for (int j = 0; j <= userList.size() - 1; j++){
                    if (userList.get(j).getLibraryNumber().equals(libraryNumber)){
                        userList.get(j).getBookList().remove(bookList.get(i));
                    }
                }
                System.out.println("Thank you for returning the book");
                matchFound = true;
            }
        }
        if(!matchFound){
            System.out.println("This is not a valid book to return");
        }
    }

    public static boolean validChoice (String userInput){
        if (userInput.length() != 1){
            return false;
        }
        if (!Character.isDigit(userInput.charAt(0))){
            return false;
        }
        if (Integer.valueOf(userInput) < 1 || Integer.valueOf(userInput) > 7){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bookSetup();
        movieSetup();
        userSetup();
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!");
        printMenu();
        String userInput = sc.nextLine();
        while (!validChoice(userInput)){
            System.out.println("Please select a valid option! 1-7");
            userInput = sc.nextLine();
        }
        while (!userInput.equals("7")) {
            if (userInput.equals("1")){
                showAvailableBooks();
            }
            if (userInput.equals("2")){
                String check = authenticateUser(sc);
                if (check.length() == 0){
                    System.out.println("Invalid Entry");
                }
                else {
                    checkoutBook(sc, check);
                }
            }
            if (userInput.equals("3")){
                String check = authenticateUser(sc);
                if (check.length() == 0){
                    System.out.println("Invalid Entry");
                }
                else {
                    returnBook(sc, check);
                }
            }
            if (userInput.equals("4")){
                showAvailableMovies();
            }
            if (userInput.equals("5")){
                checkoutMovie(sc);
            }
            if (userInput.equals("6")){
                String check = authenticateUser(sc);
                if (check.length() == 0){
                    System.out.println("Invalid Entry");
                }
                else {
                    displayUser(check);
                }
            }
            System.out.println();
            printMenu();
            userInput = sc.nextLine();
            while (!validChoice(userInput)){
                System.out.println("Please select a valid option! 1-7");
                userInput = sc.nextLine();
            }
        }
    }
}
