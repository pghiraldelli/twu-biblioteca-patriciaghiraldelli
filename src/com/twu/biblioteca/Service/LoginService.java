package com.twu.biblioteca.Service;

import com.twu.biblioteca.Repository.UserRepository;
import java.util.stream.Stream;
import com.twu.biblioteca.Models.User;

public class LoginService {
    private UserRepository userRepository;
    private User loggedUser;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.loggedUser = null;
    }

    public boolean login(String number, String password){
        this.loggedUser = getUserWithCredentials(number,password);
        if(this.loggedUser != null) return true;
        return false;
    }

    private User getUserWithCredentials(String number, String password){
        Stream filteredUsers = filterUsers(number, password);
        User user = (User)filteredUsers.findFirst().orElse(null);
        return user;
    }

    private Stream filterUsers(String number, String password){
        return userRepository.getUsers().stream().filter(o -> (o.getNumber().equals(number) && o.getPassword().equals(password)));
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
