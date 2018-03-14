package com.twu.biblioteca.Service;

import com.twu.biblioteca.Repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class LoginServiceTest {

    private LoginService ls;
    private UserRepository ur;

    @Before
    public void setUp() throws Exception {
        ur = new UserRepository();
        ls = new LoginService(ur);
    }

    @Test
    public void shouldLogin() {
        String number = "111-1111";
        String password = "pass";

        assertTrue(ls.login(number, password));
        assertTrue(ls.getLoggedUser().getNumber().equals(number));
    }

    @Test
    public void shouldNotLogin() {
        String number = "111-1111";
        String password = "pas";

        assertFalse(ls.login(number, password));
    }
}
