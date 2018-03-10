package Utils;

import com.twu.biblioteca.Models.Book;
import com.twu.biblioteca.Repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<Book>();
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
