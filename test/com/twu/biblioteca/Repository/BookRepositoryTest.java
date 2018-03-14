package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Utils.TestUtils;
import com.twu.biblioteca.Models.Item;
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
        List<Item> expected = getBooks();
        List<Item> results = br.getItemList();

        assertEquals(expected.get(0), results.get(0));
        assertEquals(expected.get(1), results.get(1));
        assertEquals(expected.get(2), results.get(2));
    }
}
