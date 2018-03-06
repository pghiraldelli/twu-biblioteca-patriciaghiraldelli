package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.*;

public class TaskManagerTest extends TestUtils{

    @Test
    public void testCheckoutBook_existingBook_shouldRemoveBook(){
        int indexToRemove = 0;
        TaskManager tm = new TaskManager();

        Book bookToCheckout = tm.getBookList().get(indexToRemove);

        tm.checkoutBook(indexToRemove);

        assertFalse(tm.getBookList().get(indexToRemove).equals(bookToCheckout));
    }

    @Test
    public void testCheckoutBook_nonExistingBook_shouldKeepBookList(){
        int indexToRemove = 100;
        TaskManager tm = new TaskManager();

        List<Book> booksBefore = tm.getBookList();
        tm.checkoutBook(indexToRemove);

        assertEquals(tm.getBookList().get(0), booksBefore.get(0));
        assertEquals(tm.getBookList().get(2), booksBefore.get(2));

        assertEquals(0, tm.getCheckedoutBookList().size());
    }

    @Test
    public void testReturnBook_existingBook_shouldRemoveBook(){
        int indexToRemove = 0;
        TaskManager tm = new TaskManager();
        insertCheckedoutBook(tm);

        Book bookCheckedout = tm.getCheckedoutBookList().get(indexToRemove);

        tm.returnBook(indexToRemove);

        assertTrue(tm.getCheckedoutBookList().size() == 0);
    }

    @Test
    public void testReturnBook_nonExistingBook_shouldKeepBookList(){
        int indexToRemove = 100;
        TaskManager tm = new TaskManager();
        insertCheckedoutBook(tm);

        List<Book> booksBefore = tm.getCheckedoutBookList();
        tm.returnBook(indexToRemove);

        assertEquals(tm.getCheckedoutBookList().get(0), booksBefore.get(0));

        assertEquals(3, tm.getBookList().size());
    }
}
