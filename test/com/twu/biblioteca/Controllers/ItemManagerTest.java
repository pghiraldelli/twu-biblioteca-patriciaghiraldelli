package com.twu.biblioteca.Controllers;

import Utils.TestUtils;
import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Models.Item;
import com.twu.biblioteca.Models.ItemType;
import com.twu.biblioteca.Models.Movie;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static junit.framework.TestCase.*;

public class ItemManagerTest extends TestUtils {

    private BookRepository br;
    private ItemManager im;
    private MovieRepository mr;

    @Before
    public void setUp() throws Exception {
        br = new BookRepository();
        mr = new MovieRepository();
        im = new ItemManager(br, mr);
    }

    @Test
    public void shouldRemoveBookFromCheckoutList(){
        int indexToRemove = 0;

        Book bookToCheckout = (Book) im.getBookRepository().getItemList().get(indexToRemove);

        im.checkoutItem(ItemType.BOOK, indexToRemove);

        assertFalse(im.getBookRepository().getItemList().get(indexToRemove).equals(bookToCheckout));
    }

    @Test
    public void shouldKeepBookInCheckoutList(){
        int indexToRemove = 100;

        List<Item> booksBefore = im.getBookRepository().getItemList();
        im.checkoutItem(ItemType.BOOK, indexToRemove);

        assertEquals(im.getBookRepository().getItemList().get(0), booksBefore.get(0));
        assertEquals(im.getBookRepository().getItemList().get(2), booksBefore.get(2));

        assertEquals(0, im.getBookRepository().getCheckedoutItemList().size());
    }

    @Test
    public void shouldRemoveBookFromReturnList(){
        int indexToRemove = 0;
        insertCheckedoutBook(im.getBookRepository());

        assertTrue(im.getBookRepository().getCheckedoutItemList().size() == 1);

        im.returnItem(ItemType.BOOK, indexToRemove);

        assertTrue(im.getBookRepository().getCheckedoutItemList().size() == 0);
    }

    @Test
    public void shouldKeepBookListWithInvalidBook(){
        int indexToRemove = 100;
        insertCheckedoutBook(im.getBookRepository());

        List<Item> booksBefore = im.getBookRepository().getCheckedoutItemList();
        im.returnItem(ItemType.BOOK, indexToRemove);

        assertEquals(im.getBookRepository().getCheckedoutItemList().get(0), booksBefore.get(0));

        assertEquals(3, im.getBookRepository().getItemList().size());
    }

    @Test
    public void shouldRemoveMovieFromCheckoutList(){
        int indexToRemove = 0;

        Movie movieToCheckout = (Movie) im.getMovieRepository().getItemList().get(indexToRemove);

        im.checkoutItem(ItemType.MOVIE, indexToRemove);

        assertFalse(im.getMovieRepository().getItemList().get(indexToRemove).equals(movieToCheckout));
    }

    @Test
    public void shouldKeepMovieInCheckoutList(){
        int indexToRemove = 100;

        List<Item> moviesBefore = im.getMovieRepository().getItemList();
        im.checkoutItem(ItemType.MOVIE, indexToRemove);

        assertEquals(im.getMovieRepository().getItemList().get(0), moviesBefore.get(0));
        assertEquals(im.getMovieRepository().getItemList().get(2), moviesBefore.get(2));

        assertEquals(0, im.getBookRepository().getCheckedoutItemList().size());
    }

    @Test
    public void shouldRemoveMovieFromReturnList(){
        int indexToRemove = 0;
        insertCheckedoutMovie(im.getMovieRepository());

        assertTrue(im.getMovieRepository().getCheckedoutItemList().size() == 1);

        im.returnItem(ItemType.MOVIE, indexToRemove);

        assertTrue(im.getMovieRepository().getCheckedoutItemList().size() == 0);
    }

    @Test
    public void shouldKeepMovieListWithInvalidBook(){
        int indexToRemove = 100;
        insertCheckedoutMovie(im.getMovieRepository());

        List<Item> moviesBefore = im.getMovieRepository().getCheckedoutItemList();
        im.returnItem(ItemType.MOVIE, indexToRemove);

        assertEquals(im.getMovieRepository().getCheckedoutItemList().get(0), moviesBefore.get(0));

        assertEquals(5, im.getMovieRepository().getItemList().size());
    }
}
