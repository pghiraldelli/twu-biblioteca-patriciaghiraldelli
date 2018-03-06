package com.twu.biblioteca.Controllers;

import org.junit.Test;
import static junit.framework.TestCase.*;

public class ConsoleManagerTest {
    @Test
    public void testRunTask_OptionZero_shouldReturnFalse(){
        ConsoleManager cm = new ConsoleManager();
        assertFalse(cm.runTask(0));
    }

    @Test
    public void testRunTask_Option1_shouldReturnTrue(){
        ConsoleManager cm = new ConsoleManager();
        assertTrue(cm.runTask(1));
    }

    @Test
    public void testRunTask_Option100_shouldReturnTrue(){
        ConsoleManager cm = new ConsoleManager();
        assertTrue(cm.runTask(100));
    }
}

