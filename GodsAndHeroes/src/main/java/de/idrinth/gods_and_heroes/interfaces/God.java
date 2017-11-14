package de.idrinth.gods_and_heroes.interfaces;

public interface God extends Person{
    public int getBelieve();
    public int getRenown();
    public boolean createWonder(Wonder wonder);
}
