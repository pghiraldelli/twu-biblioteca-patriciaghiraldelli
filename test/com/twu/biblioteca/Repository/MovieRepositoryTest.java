package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Utils.TestUtils;
import com.twu.biblioteca.Models.Item;
import com.twu.biblioteca.Models.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

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

    @Test
    public void shouldCreateMovieWithRate(){
        Movie movie = mr.createMovie("Movie", "2010", "Director", 10);
        assertTrue(movie.getRate() == 10);
    }

    @Test
    public void shouldCreateMovieWithNoRate(){
        Movie movie = mr.createMovie("Movie", "2010", "Director");
        assertTrue(movie.getRate() == 0);
    }
}
