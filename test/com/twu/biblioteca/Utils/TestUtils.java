package com.twu.biblioteca.Utils;

import com.twu.biblioteca.Models.*;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public List<Item> getMovies(){
        List<Item> movies = new ArrayList<Item>();
        movies.add(new Movie("Movie 1", "2010", "Director 1", 3));
        movies.add(new Movie("Movie 2", "2018", "Director 2"));
        movies.add(new Movie("Movie 3", "1850", "Director 3", 5));
        movies.add(new Movie("Movie 4", "1900", "Director 4", 10));
        movies.add(new Movie("Movie 5", "2000", "Director 5", 7));
        return movies;
    }

    public List<Item> getBooks(){
        List<Item> books = new ArrayList<Item>();
        books.add(new Book("Book 1", "Author 1", "1994"));
        books.add(new Book("Book 2", "Author 2", "2018"));
        books.add(new Book("Book 3", "Author 3", "2000"));
        return books;
    }

    public void insertCheckedoutBook(BookRepository bs){
        Book book = new Book("Book", "Author", "1990");
        bs.addCheckedoutItem(book);
    }

    public void insertCheckedoutMovie(MovieRepository mr){
        Movie movie = new Movie("Movie", "2000", "Director");
        mr.addCheckedoutItem(movie);
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User("111-1111", "pass", UserType.LIBRARIAN));
        users.add(new User("111-1113", "pass", UserType.CUSTOMER));

        for (User user: users) {
            Reservation reservation = new Reservation(getMovies().get(0), user);
            user.getReservationList().add(reservation);
        }

        return users;
    }

    public User getLoggedUser(){
        return getUsers().get(0);
    }
}
