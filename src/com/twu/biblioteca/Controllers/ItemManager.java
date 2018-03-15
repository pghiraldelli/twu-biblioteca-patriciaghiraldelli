package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.*;
import com.twu.biblioteca.Repository.BookRepository;
import com.twu.biblioteca.Repository.ItemRepositoryInterface;
import com.twu.biblioteca.Repository.MovieRepository;
import com.twu.biblioteca.Repository.UserRepository;
import com.twu.biblioteca.Utils.MessageContainer;

public class ItemManager {
    private BookRepository br;
    private MovieRepository mr;
    private UserRepository ur;

    public ItemManager(BookRepository br, MovieRepository mr, UserRepository ur) {
        this.br = br;
        this.mr = mr;
        this.ur = ur;
    }

    public String getItemList(int type){
        if(type == ItemType.BOOK) return MessageContainer.getBookDetails(br.getItemList(), "Book details");
        else if(type == ItemType.MOVIE) return MessageContainer.getMovieDetails(mr.getItemList(), "Movie details");
        else {
            prepareReservations();
            return MessageContainer.getReservationDetails(ur.getCustomers(), "Reservations");
        }
    }

    private void prepareReservations(){
        Movie movie = new Movie("Movie A", "2000", "Director");
        for(Customer customer: ur.getCustomers()){
            customer.getReservationList().add(new Reservation(movie, customer));
        }
    }

    public String getCheckedoutItemList(int type){
        if(type == ItemType.BOOK) return MessageContainer.getBookDetails(br.getCheckedoutItemList(), "Books to return");
        return MessageContainer.getMovieDetails(mr.getCheckedoutItemList(), "Movies to return");
    }

    public boolean checkoutItem(int type, int index, User user){
        if(type == ItemType.BOOK) return doCheckout(this.br, index, user);
        return doCheckout(this.mr, index, user);
    }

    private boolean doCheckout (ItemRepositoryInterface rep, int index, User user){
        if(index >= rep.getItemList().size()) return false;

        Item item = rep.getItemList().get(index);
        item.setStatus(ItemStatus.CHECKEDOUT);
        rep.removeItem(index);
        rep.addCheckedoutItem(item);
        user.getReservationList().add(createReservation(user,item));
        return true;
    }

    private Reservation createReservation(User user, Item item){
        return new Reservation(item, user);
    }

    public boolean returnItem(int type, int index){
        if(type == ItemType.BOOK) return doReturn(br, index);
        return doReturn(mr, index);
    }

    private boolean doReturn(ItemRepositoryInterface rep, int index){
        if(index >= rep.getCheckedoutItemList().size()) return false;

        Item item = rep.getCheckedoutItemList().get(index);
        rep.removeCheckedoutItem(index);
        rep.addItem(item);
        return true;
    }

    public boolean hasItemToReturn(int type){
        if(type == ItemType.BOOK) return (this.br.getCheckedoutItemList().size() > 0 ?  true : false);
        return this.mr.getCheckedoutItemList().size() > 0 ? true : false;
    }

    public boolean hasItemToCheckout(int type){
        if(type == ItemType.BOOK) return (this.br.getItemList().size() > 0 ?  true : false);
        return this.mr.getItemList().size() > 0 ? true : false;
    }

    public BookRepository getBookRepository() {
        return br;
    }

    public MovieRepository getMovieRepository() {
        return mr;
    }

    public String getCustomerInformation(Customer loggedUser) {
        return MessageContainer.getCustomerInformation(loggedUser);
    }
}
