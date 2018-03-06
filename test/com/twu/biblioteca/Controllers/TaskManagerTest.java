package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.*;

public class TaskManagerTest {

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
}
