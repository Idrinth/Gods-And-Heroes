package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.interfaces.God;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testInitialize() {
        System.out.println("startFresh + end");
        Game game = new Game("example");
        assertTrue(God.class.isInstance(game.getGod()));
        assertEquals("example", game.getGod().getName());
        game.cancel();
        game.purge();
    }
}
