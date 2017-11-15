package de.idrinth.gods_and_heroes.interfaces;

import java.util.List;

public interface God extends Individual {
    public int getBelieve();
    public List<Believer> getBelievers();
    public int getRenown();
    public boolean createWonder(Wonder wonder);
    public List<Hero> getHeroes();
    public List<Priest> getPriests();
}
