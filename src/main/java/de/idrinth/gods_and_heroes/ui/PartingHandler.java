package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.Mortal;

public interface PartingHandler {
    void addDeathCase(Mortal mortal);
    void addLeaveCase(Mortal mortal);
}
