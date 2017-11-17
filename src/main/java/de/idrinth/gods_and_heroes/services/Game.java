package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.implementation.Philosophy;
import de.idrinth.gods_and_heroes.implementation.Player;
import de.idrinth.gods_and_heroes.interfaces.God;

public class Game implements GameHandler {
    private final God god;
    private static Scheduler timer;

    public Game(String name) {
        this.god = new Player(name, new Philosophy());
        timer.scheduleAtFixedRate(new TaskHandler(god), 0, 1000);
    }

    @Override
    public God getGod() {
        return god;
    }

    @Override
    public void end() {
        timer.cancel();
        timer.purge();
    }

    public static Scheduler getTimer() {
        return timer;
    }

    public static void setTimer(Scheduler timerImpl) {
        timer = timerImpl;
    }
}
