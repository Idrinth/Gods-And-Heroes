package de.idrinth.gods_and_heroes.interfaces;

import java.math.BigDecimal;

public interface Individual extends Person {
    public BigDecimal getLevel();
    public void addExperience(BigDecimal experience);
}
