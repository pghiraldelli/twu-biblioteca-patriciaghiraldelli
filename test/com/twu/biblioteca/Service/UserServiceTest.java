package com.twu.biblioteca.Service;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class UserServiceTest {

    private UserService us;

    @Before
    public void setUp() throws Exception {
        us = new UserService();
    }

    @Test
    public void shouldCreateUser() {
        String number = "1111111";
        String password = "pass";

        try{
            us.newUser(number, password);
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void shouldNotCreateUser() {
        String number = "11A111";
        String password = "pass";

        try{
            us.newUser(number, password);
        }catch (Exception e){
            assertTrue(true);
            return;
        }
        fail();
    }
}
