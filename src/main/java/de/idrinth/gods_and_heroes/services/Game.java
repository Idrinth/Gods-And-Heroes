package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.implementation.Philosophy;
import de.idrinth.gods_and_heroes.implementation.Player;
import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.ui.AttributeList;

public class Game implements GameHandler {
    private final Player god;
    private static Scheduler timer;

    public Game(String name) {
        this.god = new Player(name, new Philosophy());
        getTimer().scheduleAtFixedRate(new TaskHandler(god), 0, 1000);
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
    private Scheduler getTimer() {
        if(null==timer) {
            setTimer(new TimerScheduler());
        }
        return timer;
    }

    public static void setTimer(Scheduler timerImpl) {
        timer = timerImpl;
    }

    @Override
    public AttributeList getAttributeList() {
        return god;
    }
}
