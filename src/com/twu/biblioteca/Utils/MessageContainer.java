package com.twu.biblioteca.Utils;

import com.twu.biblioteca.Models.*;
import java.util.List;

public class MessageContainer {

    private static int MESSAGE_SIZE = 32;

    public static String getWelcomeMessage(){
        return "~~~~ Welcome to Biblioteca! ~~~~";
    }

    public static String getMenuOptions(){
        String menu = getActionTitle("Menu");
        menu += getMenuGrid();
        return menu;
    }

    public static String getBookDetails(List<Book> books, String title){
        String bookList = getActionTitle(title);
        bookList += getBookGrid(books);
        return bookList;
    }

    public static String getMovieDetails(List<Movie> movies, String title){
        String movieList = getActionTitle(title);
        movieList += getMovieGrid(movies);
        return movieList;
    }

    private static String getActionTitle(String title){
        String str = "\n--------------------------------\n";
        str +=  centralizeString("***  "+title+"  ***", MESSAGE_SIZE)+"\n";
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

    private static String getMovieGrid(List<Movie> movies){
        String str = "";
        for (int i = 0; i < movies.size() ; i++) {
            Movie movie = movies.get(i);
            str += "| "+i+" | "+movie.getName()+" | "+movie.getYear()+" | "+movie.getDirector()+" | "+movie.getRate()+" |\n";
        }
        return str;
    }

    private static String getMenuGrid(){
        String str =        "|    0- Quit                |\n";
        str +=              "|    1- Book details        |\n";
        str +=              "|    2- Checkout book       |\n";
        str +=              "|    3- Return book         |\n";
        str +=              "|    4- Movie details       |\n";
        return str;
    }

    private static String centralizeString(String str, int size){
        int totalSpaces = size - str.length();
        if(totalSpaces <= 0) return str.substring(0, size);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalSpaces/2 ; i++) {
            sb.append(" ");
        }

        sb.append(str);

        for (int i = 0; i < totalSpaces/2 ; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
