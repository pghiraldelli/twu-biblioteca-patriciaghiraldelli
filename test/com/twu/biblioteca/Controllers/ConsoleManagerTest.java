package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Task;
import org.junit.Before;
import org.junit.Test;

import java.io.Console;

import static junit.framework.TestCase.*;

public class ConsoleManagerTest {
    private ConsoleManager cm;

    @Before
    public void setUp() throws Exception {
        cm = new ConsoleManager();
    }

    @Test
    public void shouldExitMenu(){
        assertFalse(cm.runTask(Task.QUIT));
    }

    @Test
    public void shouldStayInMenuWithValidOption(){
        assertTrue(cm.runTask(Task.BOOKDETAILS));
    }

    @Test
    public void shouldStayInMenuWithInvalid(){
        assertTrue(cm.runTask(Task.INVALIDOPTION));
    }
}

