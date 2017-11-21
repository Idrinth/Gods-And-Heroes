package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import java.math.BigDecimal;

public class HumanPriest extends HigherServant implements Priest {
    public HumanPriest(God god) {
        super(god);
    }

    @Override
    protected BigDecimal getDeathFactor() {
        return BigDecimal.valueOf(0.25);
    }
}
