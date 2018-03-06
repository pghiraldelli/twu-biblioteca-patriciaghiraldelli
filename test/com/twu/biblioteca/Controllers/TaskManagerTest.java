package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Book;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class TaskManagerTest {

    @Test
    public void testCheckoutBook_existingBook_shouldRemoveBook(){
        int indexToRemove = 0;
        TaskManager tm = new TaskManager();

        Book bookToCheckout = tm.getBookList().get(indexToRemove);

        tm.checkoutBook(0);

        assertFalse(tm.getBookList().get(indexToRemove).equals(bookToCheckout));
    }
}
