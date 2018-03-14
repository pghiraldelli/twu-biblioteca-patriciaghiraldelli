package com.twu.biblioteca.Service;

import com.twu.biblioteca.Utils.StringUtils;
import com.twu.biblioteca.Models.User;

public class UserService {

    private String numberMask = "###-####";

    public User newUser(String number, String password) throws Exception{
        verifyNumber(number);
        String formatted = StringUtils.formatString(number, numberMask);
        return new User(formatted, password);
    }

    private void verifyNumber(String num) throws Exception{
        if(!StringUtils.containsOnlyNumbers(num) || num.length() != 7) {
            throw new Exception();
        }
    }
}
