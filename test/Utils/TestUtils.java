package Utils;

import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Models.Item;
import com.twu.biblioteca.Models.Movie;
import com.twu.biblioteca.Repository.BookRepository;

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
        bs.addCheckedoutBook(book);
    }
}
