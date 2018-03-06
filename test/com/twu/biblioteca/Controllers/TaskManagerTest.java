package com.twu.biblioteca.Controllers;

import org.junit.Test;
import static junit.framework.TestCase.*;

public class TaskManagerTest {

    @Test
    public void testRunTask_OptionZero_shouldReturnFalse(){
        TaskManager tm = new TaskManager();
        assertFalse(tm.runTask(0));
    }

    @Test
    public void testRunTask_Option1_shouldReturnTrue(){
        TaskManager tm = new TaskManager();
        assertTrue(tm.runTask(1));
    }

    @Test
    public void testRunTask_Option100_shouldReturnTrue(){
        TaskManager tm = new TaskManager();
        assertTrue(tm.runTask(100));
    }
}
