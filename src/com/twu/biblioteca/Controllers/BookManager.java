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
        books.add(createBook("Book 1", "Author 1", "1994"));
        books.add(createBook("Book 2", "Author 2", "2018"));
        books.add(createBook("Book 3", "Author 3", "2000"));
        return books;
    }

    private Book createBook(String title, String author, String year){
        return new Book(title, author, year);
    }

    protected void removeBook(int index){
        this.bookList.remove(index);
    }
}
