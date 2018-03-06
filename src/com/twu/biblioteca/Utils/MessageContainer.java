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

    public static String getBookList(List<Book> books){
        String bookList = getActionTitle("Book List");
        bookList += getBookGrid(books);
        return bookList;
    }

    private static String getActionTitle(String title){
        String str = "\n-----------------------------\n";
        str +=       "    ***  "+title+"  ***    \n";
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

    private static String getMenuGrid(){
        String str =        "|    1- Book details        |\n";
        return str;
    }

    //TODO: Method to format grid to different sizes of strings
}
