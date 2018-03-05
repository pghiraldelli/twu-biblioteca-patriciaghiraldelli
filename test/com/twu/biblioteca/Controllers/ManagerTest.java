package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ManagerTest {

    @Test
    public void testGetBookList(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1"));
        books.add(new Book("Book 2"));
        books.add(new Book("Book 3"));

        Manager man = new Manager();
        List<Book> results = man.getBookList();

        assertEquals(books.get(0), results.get(0));
        assertEquals(books.get(1), results.get(1));
        assertEquals(books.get(2), results.get(2));
    }
}
