package com.twu.biblioteca.Models;

public class Book {
    private String title;
    private String author;
    private String year;

    public Book(String title, String author, String year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public boolean equals(Object obj){
        if (this.getClass() != obj.getClass()) return false;

        Book book = (Book) obj;

        if(this.title.equals(book.getTitle()) &&
           this.author.equals(book.getAuthor()) &&
           this.year.equals(book.getYear())) return true;
        return false;
    }

}
