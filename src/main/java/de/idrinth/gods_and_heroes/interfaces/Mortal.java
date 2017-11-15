package de.idrinth.gods_and_heroes.interfaces;

import java.math.BigDecimal;

public interface Mortal extends Person {
    public BigDecimal getOnDeathRenown();
    public BigDecimal getOnDeathSouls();
    public BigDecimal getOnDeathBelieve();
    public boolean isDead();
}
