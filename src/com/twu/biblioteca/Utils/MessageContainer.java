package com.twu.biblioteca.Utils;

import com.twu.biblioteca.Models.*;
import java.util.List;

public class MessageContainer {

    public static String getWelcomeMessage(){
        return "~~~~ Welcome to Biblioteca! ~~~~";
    }

    public static String getMenuOptions(){
        String menu = getActionTitle("Menu");
        menu += getMenuGrid();
        return menu;
    }

    public static String getBookDetails(List<Book> books){
        String bookList = getActionTitle("Book Details");
        bookList += getBookGrid(books);
        return bookList;
    }

    private static String getActionTitle(String title){
        String str = "\n--------------------------------\n";
        str +=       "    ***  "+title+"  ***    \n";
        str +=       "--------------------------------\n";
        return str;
    }

    private static String getBookGrid(List<Book> books){
        String str = "";
        for (int i = 0; i < books.size() ; i++) {
            Book book = books.get(i);
            str +="| "+i+" | "+book.getTitle()+" | "+book.getAuthor()+" | "+book.getYear()+" |\n";
        }
        return str;
    }

    private static String getMenuGrid(){
        String str =        "|    0- Quit                |\n";
        str +=              "|    1- Book details        |\n";
        return str;
    }

    //TODO: Method to format grid to different sizes of strings
}
