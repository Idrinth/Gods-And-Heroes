package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Hero;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import java.util.TimerTask;

public class TaskHandler extends TimerTask {
    private final God god;
    public TaskHandler(God god) {
        this.god = god;
    }
    @Override
    public void run() {
        god.processIdle();
        for(Hero hero:god.getHeroes()) {
            hero.processIdle();
        }
        for(Priest priest:god.getPriests()) {
            priest.processIdle();
        }
    }
}
