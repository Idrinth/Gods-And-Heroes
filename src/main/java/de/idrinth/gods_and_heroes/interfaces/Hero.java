package de.idrinth.gods_and_heroes.interfaces;

public interface Hero extends Individual,Mortal {
    public void addTask(Quest quest);
    public God getGod();
}
