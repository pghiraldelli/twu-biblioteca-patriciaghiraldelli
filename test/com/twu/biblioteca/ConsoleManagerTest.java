package com.twu.biblioteca;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ConsoleManagerTest {

    @Test
    public void testGetWelcomeMessage() {
        MessageContainer console = new MessageContainer();
        String msg = console.getWelcomeMessage();

        assertEquals("~~~~ Welcome to Biblioteca! ~~~~", msg);
    }
}
