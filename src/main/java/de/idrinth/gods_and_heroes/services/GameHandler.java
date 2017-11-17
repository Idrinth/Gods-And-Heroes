package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.interfaces.God;

public interface GameHandler {
    public God getGod();
    public void end();
}
