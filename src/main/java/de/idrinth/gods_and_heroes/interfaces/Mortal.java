package de.idrinth.gods_and_heroes.interfaces;

public interface Mortal extends Person {
    public int getOnDeathRenown();
    public int getOnDeathSouls();
    public int getOnDeathBelieve();
    public boolean isDead();
}
