package com.twu.biblioteca.Utils;

import com.twu.biblioteca.Models.Task;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOManager {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void printString(String str) {
        System.out.println(str);
    }

    public int readInt(){
        try {
            String input = br.readLine();
            return Integer.parseInt(input);
        } catch (Exception e) {
        }

        return Task.INVALIDOPTION;
    }

    public String readString(){
        try {
            return br.readLine().toString().trim();
        } catch (Exception e) {
        }

        return "";
    }
}
