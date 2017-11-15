package de.idrinth.gods_and_heroes.interfaces;

public interface Individual extends Person {
    public String getName();
    public int getLevel();
    public void processIdle();
    public void addExperience(int experience);
}
