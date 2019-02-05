package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.Scanner;

public class BibliotecaApp {

    public static LinkedList<Book> bookList = new LinkedList<>();

    public static void bookSetup(){
        bookList.add(new Book("Harry Potter", "Rowling", "1997", false));
        bookList.add(new Book("The Little Prince", "Saint-Exuper", "1943", false));
        bookList.add(new Book("The Lord of the Rings", "Tolkien", "1954", false));
        bookList.add(new Book("A Tale of Two Cities", "Dickens", "1859", false));
        bookList.add(new Book("Don Quixote", "Cervantes", "1612", false));
    }

    public static void printMenu(){
        System.out.println("Main Menu of Options");
        System.out.println("(1) View a List of Books");
        System.out.println("(2) Checkout a Book");
        System.out.println("(3) Return a Book");
        System.out.println("(4) Quit the Application");
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

    public static void checkoutBook(Scanner sc){
        System.out.println("Please enter the title of the book to checkout:");
        String userInput = sc.nextLine();
        boolean matchFound = false;
        for (int i = 0; i <= bookList.size() - 1; i++){
            if (userInput.trim().equals(bookList.get(i).getTitle()) && !bookList.get(i).getCheckedOut()){
                bookList.get(i).setCheckedOut(true);
                System.out.println("Thank you! Enjoy the book");
                matchFound = true;
            }
        }
        if(!matchFound){
            System.out.println("Sorry, that book is not available");
        }
    }

    public static void returnBook(Scanner sc){
        System.out.println("Please enter the title of the book to return:");
        String userInput = sc.nextLine();
        boolean matchFound = false;
        for (int i = 0; i <= bookList.size() - 1; i++){
            if (userInput.trim().equals(bookList.get(i).getTitle()) && bookList.get(i).getCheckedOut()){
                bookList.get(i).setCheckedOut(false);
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
        if (Integer.valueOf(userInput) < 1 || Integer.valueOf(userInput) > 4){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bookSetup();
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!");
        printMenu();
        String userInput = sc.nextLine();
        //iterate until a valid userInput is made
        while (!validChoice(userInput)){
            System.out.println("Please select a valid option! 1-4");
            userInput = sc.nextLine();
        }
        while (!userInput.equals("4")) {
            if (userInput.equals("1")){
                showAvailableBooks();
            }
            if (userInput.equals("2")){
                checkoutBook(sc);
            }
            if (userInput.equals("3")){
                returnBook(sc);
            }
            System.out.println();
            printMenu();
            userInput = sc.nextLine();
            while (!validChoice(userInput)){
                System.out.println("Please select a valid option! 1-4");
                userInput = sc.nextLine();
            }
        }
    }
}
