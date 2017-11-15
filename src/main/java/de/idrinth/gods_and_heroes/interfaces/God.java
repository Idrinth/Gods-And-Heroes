package de.idrinth.gods_and_heroes.interfaces;

import java.math.BigDecimal;
import java.util.List;

public interface God extends Individual {
    public BigDecimal getBelieve();
    public List<Believer> getBelievers();
    public BigDecimal getRenown();
    public boolean createWonder(Wonder wonder);
    public List<Hero> getHeroes();
    public List<Priest> getPriests();
}
