package com.twu.biblioteca;

public class Movie {
    private String name;
    private String year;
    private String director;
    private String rating;
    private boolean checkedOut;

    public Movie(String name, String year, String director, String rating, boolean checkedOut){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkedOut = checkedOut;
    }

    public void setCheckedOut(boolean checkedOut){
        this.checkedOut = checkedOut;
    }

    public String getName(){
        return this.name;
    }

    public String getYear(){
        return this.year;
    }

    public String getDirector(){
        return this.director;
    }

    public String getRating(){
        return this.rating;
    }

    public boolean getCheckedOut(){
        return this.checkedOut;
    }
}
