package com.twu.biblioteca.Repository;

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
        users.add(new User("111-1111", "pass", UserType.LIBRARIAN));
        users.add(new User("111-1112", "pass", UserType.LIBRARIAN));
        users.add(new User("111-1113", "pass", UserType.CUSTOMER));
        users.add(new User("111-1114", "pass", UserType.CUSTOMER));
    }

    public List<User> getUsers() {
        return users;
    }
}
