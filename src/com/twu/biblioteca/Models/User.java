package com.twu.biblioteca.Models;

import com.twu.biblioteca.Utils.StringUtils;

import java.text.ParseException;

public class User {
    private String number;
    private String password;
    private String numberMask = "###-####";

    public User(String number, String password) throws Exception{
        setNumber(number);
        this.password = password;
    }

    private void setNumber(String number) throws Exception{
        this.verifyNumber(number);
        this.number = StringUtils.formatString(number, numberMask);
    }

    private void verifyNumber(String num) throws Exception{
        if(!StringUtils.containsOnlyNumbers(num) || num.length() != 7) {
            throw new Exception();
        }
    }
}
