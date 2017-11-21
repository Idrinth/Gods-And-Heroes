package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.ui.AttributeList;

public interface GameHandler {
    public God getGod();
    public AttributeList getAttributeList();
    public void end();
}
