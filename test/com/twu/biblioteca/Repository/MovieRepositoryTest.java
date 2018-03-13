package com.twu.biblioteca.Repository;

import Utils.TestUtils;
import com.twu.biblioteca.Models.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class MovieRepositoryTest extends TestUtils{
    private MovieRepository mr;

    @Before
    public void setUp() throws Exception {
        mr = new MovieRepository();
    }

    @Test
    public void shouldReturnMovieList() {
        List<Item> expectedMovies = getMovies();

        assertEquals(mr.getItemList().get(0), expectedMovies.get(0));
        assertEquals(mr.getItemList().get(1), expectedMovies.get(1));
        assertEquals(mr.getItemList().get(2), expectedMovies.get(2));
        assertEquals(mr.getItemList().get(3), expectedMovies.get(3));
        assertEquals(mr.getItemList().get(4), expectedMovies.get(4));
    }
}
