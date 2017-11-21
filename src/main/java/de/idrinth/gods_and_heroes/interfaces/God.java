package de.idrinth.gods_and_heroes.interfaces;

import java.math.BigDecimal;
import javafx.collections.ObservableList;

public interface God extends Individual {
    public BigDecimal getBelieve();
    public ObservableList<Believer> getBelievers();
    public void addBeliever();
    public void addHero();
    public void addPriest();
    public BigDecimal getRenown();
    public boolean createWonder(Wonder wonder);
    public ObservableList<Hero> getHeroes();
    public ObservableList<Priest> getPriests();
}
