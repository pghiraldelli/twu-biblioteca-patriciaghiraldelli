package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Models.User;
import com.twu.biblioteca.Models.UserType;
import com.twu.biblioteca.Service.UserService;
import java.util.List;

public class UserRepository {

    private List<User> users;
    private UserService userService;

    public UserRepository(UserService userService) {
        this.userService = userService;
        createUserList();
    }

    private void createUserList(){
        try{
            users.add(userService.newUser("1111111", "pass", UserType.LIBRARIAN));
            users.add(userService.newUser("1111112", "pass", UserType.LIBRARIAN));
            users.add(userService.newUser("1111113", "pass", UserType.CUSTOMER));
            users.add(userService.newUser("1111114", "pass", UserType.CUSTOMER));
        }catch (Exception e){
            return;
        }
    }
}
