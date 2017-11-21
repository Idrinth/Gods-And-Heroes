package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Believer;
import java.math.BigDecimal;

public class HumanBeliever extends Servant implements Believer {
    @Override
    protected BigDecimal getDeathFactor() {
        return BigDecimal.valueOf(0.1);
    }

    @Override
    public boolean isLeaving() {
        BigDecimal ageFactor = divide(BigDecimal.ONE, age.add(BigDecimal.ONE).pow(10));
        return Math.random() < divide(ageFactor, BigDecimal.valueOf(777)).doubleValue();
    }
}
