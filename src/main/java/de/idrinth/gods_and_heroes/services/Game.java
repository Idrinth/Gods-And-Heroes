package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.implementation.Philosophy;
import de.idrinth.gods_and_heroes.implementation.Player;
import de.idrinth.gods_and_heroes.interfaces.God;
import java.util.Timer;

public class Game {
    public static God startFresh(String name) {
        Timer timer = new Timer(true);
        God god = new Player(name, new Philosophy());
        timer.scheduleAtFixedRate(new TaskHandler(god), 0, 1000);
        return god;
    }
}
