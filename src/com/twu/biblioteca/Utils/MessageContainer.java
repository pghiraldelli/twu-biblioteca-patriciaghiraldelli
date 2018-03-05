package com.twu.biblioteca.Utils;

import com.twu.biblioteca.Models.*;
import java.util.List;

public class MessageContainer {

    private static final int BOOKGRID_COLUMN_SIZE =  20;

    public static String getWelcomeMessage(){
        return "~~~~ Welcome to Biblioteca! ~~~~";
    }

    public static String getBookList(List<Book> books){
        String bookList = getActionTitle("Book List");
        bookList += getBookGrid(books);
        return bookList;
    }

    private static String getActionTitle(String title){
        String str = "\n-----------------------------\n";
        str +=       "    ***  Book List  ***    \n";
        str +=       "-----------------------------\n";
        return str;
    }

    private static String getBookGrid(List<Book> books){
        String str = "";
        for (Book book: books) {
            str +="| "+book.getTitle()+" | "+book.getAuthor()+" | "+book.getYear()+" |\n";
        }
        return str;
    }

    //TODO: Method to format grid to different sizes of strings
}
