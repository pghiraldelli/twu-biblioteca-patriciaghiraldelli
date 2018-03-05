package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;

    public BookManager(){
        this.bookList = createBookList();

    }

    protected List<Book> getBookList(){
        return this.bookList;
    }

    private List<Book> createBookList(){
        List<Book> books = new ArrayList<Book>();
        books.add(createBook("Book 1"));
        books.add(createBook("Book 2"));
        books.add(createBook("Book 3"));
        return books;
    }

    private Book createBook(String title){
        return new Book(title);
    }
}
