package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Utils.MessageContainer;
import org.junit.Test;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class MessageContainerTest extends TestUtils{

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

        List<Book> bookList = getBooks();

        assertEquals(expected, container.getBookList(bookList));
    }
}
