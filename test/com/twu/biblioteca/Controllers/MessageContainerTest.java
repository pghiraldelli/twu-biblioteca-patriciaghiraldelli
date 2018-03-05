package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Utils.MessageContainer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class MessageContainerTest {

    @Test
    public void testGetWelcomeMessage() {
        MessageContainer container = new MessageContainer();
        String msg = container.getWelcomeMessage();

        assertEquals("~~~~ Welcome to Biblioteca! ~~~~", msg);
    }

    @Test
    public void testGetBookList(){
        MessageContainer container = new MessageContainer();

        String expected = "\n---------------------------\n";
        expected +=       "    ***  Book List  ***    \n";
        expected +=       "-----------------------------\n";
        expected += "| Book 1 |\n";
        expected += "| Book 2 |\n";
        expected += "| Book 3 |\n";


        Book b1 = new Book("Book 1");
        Book b2 = new Book("Book 2");
        Book b3 = new Book("Book 3");
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);

        assertEquals(expected, container.getBookList(bookList));
    }
}
