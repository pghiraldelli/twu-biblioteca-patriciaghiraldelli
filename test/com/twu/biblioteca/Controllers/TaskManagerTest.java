package com.twu.biblioteca.Controllers;

import Utils.TestUtils;
import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Repository.MovieRepository;
import com.twu.biblioteca.Utils.IOManager;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static junit.framework.TestCase.*;

public class TaskManagerTest extends TestUtils {

    private IOManager iom;
    private BookRepository br;
    private TaskManager tm;
    private MovieRepository mr;

    @Before
    public void setUp() throws Exception {
        iom = new IOManager();
        br = new BookRepository();
        mr = new MovieRepository();
        tm = new TaskManager(iom, br, mr);
    }

    @Test
    public void shouldRemoveBookFromCheckoutList(){
        int indexToRemove = 0;

        Book bookToCheckout = tm.getBookService().getBookList().get(indexToRemove);

        tm.checkoutBook(indexToRemove);

        assertFalse(tm.getBookService().getBookList().get(indexToRemove).equals(bookToCheckout));
    }

    @Test
    public void shouldKeepBookInCheckoutList(){
        int indexToRemove = 100;

        List<Book> booksBefore = tm.getBookService().getBookList();
        tm.checkoutBook(indexToRemove);

        assertEquals(tm.getBookService().getBookList().get(0), booksBefore.get(0));
        assertEquals(tm.getBookService().getBookList().get(2), booksBefore.get(2));

        assertEquals(0, tm.getBookService().getCheckedoutBookList().size());
    }

    @Test
    public void shouldRemoveBookFromReturnList(){
        int indexToRemove = 0;
        insertCheckedoutBook(tm.getBookService());

        Book bookCheckedout = tm.getBookService().getCheckedoutBookList().get(indexToRemove);

        tm.returnBook(indexToRemove);

        assertTrue(tm.getBookService().getCheckedoutBookList().size() == 0);
    }

    @Test
    public void shouldKeepBookListWithInvalidBook(){
        int indexToRemove = 100;
        insertCheckedoutBook(tm.getBookService());

        List<Book> booksBefore = tm.getBookService().getCheckedoutBookList();
        tm.returnBook(indexToRemove);

        assertEquals(tm.getBookService().getCheckedoutBookList().get(0), booksBefore.get(0));

        assertEquals(3, tm.getBookService().getBookList().size());
    }
}
