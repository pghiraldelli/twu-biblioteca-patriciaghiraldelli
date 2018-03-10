package com.twu.biblioteca.Repository;

import Utils.TestUtils;
import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Repository.BookRepository;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

public class BookRepositoryTest extends TestUtils {

    @Test
    public void testGetBookList(){
        List<Book> expected = getBooks();

        BookRepository man = new BookRepository();
        List<Book> results = man.getBookList();

        assertEquals(expected.get(0), results.get(0));
        assertEquals(expected.get(1), results.get(1));
        assertEquals(expected.get(2), results.get(2));
    }
}
