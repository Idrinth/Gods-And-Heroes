package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.implementation.Philosophy;
import de.idrinth.gods_and_heroes.implementation.Player;
import de.idrinth.gods_and_heroes.interfaces.God;
import java.util.Timer;

public class Game extends Timer implements GameHandler {
    public static Game g;
    private final God god;

    public Game(String name) {
        super("base-game", true);
        this.god = new Player(name, new Philosophy());
        super.scheduleAtFixedRate(new TaskHandler(god), 0, 1000);
        if(g != null) {
            g.end();
        }
        g = this;
    }

    @Override
    public God getGod() {
        return god;
    }

    @Override
    public void end() {
        cancel();
        purge();
    }
}
