package com.twu.biblioteca.Repository;

import Utils.TestUtils;
import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

public class BookRepositoryTest extends TestUtils {
    private BookRepository br;

    @Before
    public void setUp() throws Exception {
        br = new BookRepository();
    }

    @Test
    public void shouldGetBookList(){
        List<Book> expected = getBooks();
        List<Book> results = br.getBookList();

        assertEquals(expected.get(0), results.get(0));
        assertEquals(expected.get(1), results.get(1));
        assertEquals(expected.get(2), results.get(2));
    }
}
