package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Models.Customer;
import com.twu.biblioteca.Models.Librarian;
import com.twu.biblioteca.Models.User;
import com.twu.biblioteca.Models.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users;

    public UserRepository() {
        createUserList();
    }

    private void createUserList(){
        users = new ArrayList<User>();
        users.add(new Librarian("111-1111", "pass"));
        users.add(new Librarian("111-1112", "pass"));

        users.add(new Customer("111-1113", "pass", "Name 1", "customer@eg.com", "21999999999"));
        users.add(new Customer("111-1114", "pass", "Name 2", "customer2@eg.com", "21988999999"));
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        for (User user: users) {
            if(user.getType() == UserType.CUSTOMER) customers.add((Customer) user);
        }
        return customers;
    }

    public List<User> getUsers(){
        return users;
    }
}
