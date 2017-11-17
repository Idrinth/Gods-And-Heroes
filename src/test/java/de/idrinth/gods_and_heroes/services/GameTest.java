package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.interfaces.God;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testStartFresh() {
        System.out.println("startFresh");
        God result = Game.startFresh("example");
        assertTrue(God.class.isInstance(result));
        assertEquals("example", result.getName());
    }
}
