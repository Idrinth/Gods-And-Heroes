package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.implementation.Philosophy;
import de.idrinth.gods_and_heroes.implementation.Player;
import de.idrinth.gods_and_heroes.interfaces.God;
import java.util.Timer;

public class Game extends Timer implements GameHandler {
    private final God god;

    public Game(String name) {
        super("base-game", true);
        this.god = new Player(name, new Philosophy());
        super.scheduleAtFixedRate(new TaskHandler(god), 0, 1000);
    }

    @Override
    public God getGod() {
        return god;
    }

    public void end() {
        cancel();
        purge();
    }
}
