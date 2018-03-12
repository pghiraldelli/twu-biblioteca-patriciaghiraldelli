package com.twu.biblioteca.Controllers;

import Utils.TestUtils;
import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Models.Item;
import com.twu.biblioteca.Models.Movie;
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

        Book bookToCheckout = (Book)tm.getBookRepository().getBookList().get(indexToRemove);

        tm.checkoutBook(indexToRemove);

        assertFalse(tm.getBookRepository().getBookList().get(indexToRemove).equals(bookToCheckout));
    }

    @Test
    public void shouldKeepBookInCheckoutList(){
        int indexToRemove = 100;

        List<Item> booksBefore = tm.getBookRepository().getBookList();
        tm.checkoutBook(indexToRemove);

        assertEquals(tm.getBookRepository().getBookList().get(0), booksBefore.get(0));
        assertEquals(tm.getBookRepository().getBookList().get(2), booksBefore.get(2));

        assertEquals(0, tm.getBookRepository().getCheckedoutBookList().size());
    }

    @Test
    public void shouldRemoveBookFromReturnList(){
        int indexToRemove = 0;
        insertCheckedoutBook(tm.getBookRepository());

        Book bookCheckedout = (Book)tm.getBookRepository().getCheckedoutBookList().get(indexToRemove);

        tm.returnBook(indexToRemove);

        assertTrue(tm.getBookRepository().getCheckedoutBookList().size() == 0);
    }

    @Test
    public void shouldKeepBookListWithInvalidBook(){
        int indexToRemove = 100;
        insertCheckedoutBook(tm.getBookRepository());

        List<Item> booksBefore = tm.getBookRepository().getCheckedoutBookList();
        tm.returnBook(indexToRemove);

        assertEquals(tm.getBookRepository().getCheckedoutBookList().get(0), booksBefore.get(0));

        assertEquals(3, tm.getBookRepository().getBookList().size());
    }

    @Test
    public void shouldRemoveMovieFromCheckoutList(){
        int indexToRemove = 0;

        Movie movieToCheckout = (Movie) tm.getMovieRepository().getMovieList().get(indexToRemove);

        tm.checkoutMovie(indexToRemove);

        assertFalse(tm.getMovieRepository().getMovieList().get(indexToRemove).equals(movieToCheckout));
    }

    @Test
    public void shouldKeepMovieInCheckoutList(){
        int indexToRemove = 100;

        List<Item> moviesBefore = tm.getMovieRepository().getMovieList();
        tm.checkoutMovie(indexToRemove);

        assertEquals(tm.getMovieRepository().getMovieList().get(0), moviesBefore.get(0));
        assertEquals(tm.getMovieRepository().getMovieList().get(2), moviesBefore.get(2));

        assertEquals(0, tm.getBookRepository().getCheckedoutBookList().size());
    }
}
