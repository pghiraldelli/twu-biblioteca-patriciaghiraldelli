package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Author 1", "1994"));
        books.add(new Book("Book 2", "Author 2", "2018"));
        books.add(new Book("Book 3", "Author 3", "2000"));
        return books;
    }
}
