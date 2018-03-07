package com.twu.biblioteca.Controllers;

import com.twu.biblioteca.Models.Task;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class ConsoleManagerTest {
    @Test
    public void testRunTask_OptionZero_shouldExitMenu(){
        ConsoleManager cm = new ConsoleManager();
        assertFalse(cm.runTask(Task.QUIT));
    }

    @Test
    public void testRunTask_Option1_shouldStayInMenu(){
        ConsoleManager cm = new ConsoleManager();
        assertTrue(cm.runTask(Task.BOOKDETAILS));
    }

    @Test
    public void testRunTask_Option100_shouldStayInMenu(){
        ConsoleManager cm = new ConsoleManager();
        assertTrue(cm.runTask(Task.INVALIDOPTION));
    }
}

