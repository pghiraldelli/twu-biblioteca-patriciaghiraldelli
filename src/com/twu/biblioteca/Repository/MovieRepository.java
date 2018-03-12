package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private List<Movie> movieList;

    public MovieRepository() {
        this.movieList = createMovieList();
    }

    public List<Movie> createMovieList(){
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Movie 1", "2010", "Director 1", 3));
        movies.add(new Movie("Movie 2", "2018", "Director 2", 1));
        movies.add(new Movie("Movie 3", "1850", "Director 3", 5));
        movies.add(new Movie("Movie 4", "1900", "Director 4", 10));
        movies.add(new Movie("Movie 5", "2000", "Director 5", 7));
        return movies;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
