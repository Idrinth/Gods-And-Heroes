package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.implementation.Philosophy;
import de.idrinth.gods_and_heroes.implementation.Player;
import de.idrinth.gods_and_heroes.interfaces.God;
import java.util.Timer;

public class Game {
    protected static final Timer TIMER = new Timer(true);
    public static God startFresh(String name) {
        God god = new Player(name, new Philosophy());
        TIMER.scheduleAtFixedRate(new TaskHandler(god), 0, 1000);
        return god;
    }
}
