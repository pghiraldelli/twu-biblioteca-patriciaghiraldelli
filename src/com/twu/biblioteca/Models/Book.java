package com.twu.biblioteca.Models;

public class Book {
    private String title;

    public Book(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean equals(Object obj){
        if (this.getClass() != obj.getClass()) return false;

        Book book = (Book) obj;

        if(this.title.equals(book.getTitle())) return true;
        return false;
    }

}
