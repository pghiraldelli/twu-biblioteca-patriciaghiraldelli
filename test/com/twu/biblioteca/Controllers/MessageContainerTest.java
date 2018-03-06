package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Utils.MessageContainer;
import org.junit.Test;
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

        String expected = "\n-----------------------------\n";
        expected +=       "    ***  Book List  ***    \n";
        expected +=       "-----------------------------\n";
        expected += "| Book 1 | Author 1 | 1994 |\n";
        expected += "| Book 2 | Author 2 | 2018 |\n";
        expected += "| Book 3 | Author 3 | 2000 |\n";

        String result = container.getBookList(getBooks());
        assertEquals(expected, result);
    }

    @Test
    public void testGetMenuOptions(){
        String expected = "\n-----------------------------\n";
        expected +=       "    ***  Menu  ***    \n";
        expected +=       "-----------------------------\n";;
        expected +=        "|    0- Quit                |\n";
        expected +=        "|    1- Book details        |\n";

        assertEquals(expected, MessageContainer.getMenuOptions());
    }
}
