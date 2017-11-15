package de.idrinth.gods_and_heroes.interfaces;

public interface Priest extends Individual,Mortal {
    public void addTask(Wonder wonder);
    public God getGod();
}