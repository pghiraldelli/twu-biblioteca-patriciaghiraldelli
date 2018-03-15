package com.twu.biblioteca.Utils;

import com.twu.biblioteca.Models.*;
import java.util.List;

public class MessageContainer {

    private static int MESSAGE_SIZE = 32;
    public static final String MSG_MENU_OPTION = "Choose the menu option:";
    public static final String MSG_INVALID_OPTION = "\n::Error:: Select a valid option!";
    public static final String WELCOME_MESSAGE = "~~~~ Welcome to Biblioteca! ~~~~";
    public static final String GOODBYE_MESSAGE = "~~~~ Thank you for using Biblioteca! Bye Bye! ~~~~";

    public static String getMenuOptions(User loogedUser){
        String menu = getActionTitle("Menu");
        menu += getMenuGrid(loogedUser);
        return menu;
    }

    public static String getReservationDetails(List<Customer> customers, String title){
        String bookList = getActionTitle(title);
        bookList += getReservationGrid(customers);
        return bookList;
    }

    public static String getBookDetails(List<Item> books, String title){
        String bookList = getActionTitle(title);
        bookList += getBookGrid(books);
        return bookList;
    }

    public static String getMovieDetails(List<Item> movies, String title){
        String movieList = getActionTitle(title);
        movieList += getMovieGrid(movies);
        return movieList;
    }

    private static String getActionTitle(String title){
        String str = "\n--------------------------------\n";
        str +=  StringUtils.centralizeString("***  "+title+"  ***", MESSAGE_SIZE)+"\n";
        str +=       "--------------------------------\n";
        return str;
    }

    private static String getReservationGrid(List<Customer> users){
        String str = "";
        for (Customer user : users) {
            for (int i = 0; i < user.getReservationList().size() ; i++) {
                Reservation reservation = user.getReservationList().get(i);
                str += "| "+reservation.getUser().getNumber()+" | "+reservation.getItem().getName()+" |\n";
            }
        }
        return str;
    }

    private static String getBookGrid(List<Item> books){
        String str = "";
        for (int i = 0; i < books.size() ; i++) {
            Book book = (Book) books.get(i);
            str +="| "+i+" | "+book.getTitle()+" | "+book.getAuthor()+" | "+book.getYear()+" |\n";
        }
        return str;
    }

    private static String getMovieGrid(List<Item> movies){
        String str = "";
        for (int i = 0; i < movies.size() ; i++) {
            Movie movie = (Movie)movies.get(i);
            str += "| "+i+" | "+movie.getName()+" | "+movie.getYear()+" | "+movie.getDirector()+" | "+getMovieRate(movie.getRate())+" |\n";
        }
        return str;
    }

    private static String getMovieRate(int rate){
        if(rate == 0) return "unrated";
        return rate+"";
    }

    private static String getMenuGrid(User loggedUser){
        String str =        "|    0- Quit                |\n";
        str +=              "|    1- Book details        |\n";
        str +=              "|    2- Checkout book       |\n";
        str +=              "|    3- Return book         |\n";
        str +=              "|    4- Movie details       |\n";
        str +=              "|    5- Checkout movie      |\n";
        str +=              "|    6- Return movie        |\n";
        if(loggedUser.getType() == UserType.LIBRARIAN)
            str +=          "|    7- Reservation details |\n";
        return str;
    }

    public static String getNoAvaibleItemsMsg(String itemName){
        return "\n::Attention:: There are no available "+itemName+". Choose another option.";
    }

    public static String getNumberItemMsg(String itemName, String action){
        return "\nEnter the number of the "+itemName+" to "+action+": ";
    }

    public static String getNoItemsReturnMsg(String itemName){
        return "\n::Attention:: There are no "+itemName+" to return. Choose another option.";
    }

    public static String getSuccessEnjoyMsg(String itemName){
        return "\n::Success:: Thank you! Enjoy the "+itemName+".\n";
    }

    public static String getInvalidItemMsg(String itemName, String action){
        return "\n::Error:: That is not a valid "+itemName+" to "+action+"\n";
    }

    public static String getSuccessReturnMsg(String itemName){
        return "\n::Success:: Thank you for returning the "+itemName+".\n";
    }
}
