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
        BigDecimal ageFactor = divide(BigDecimal.ONE, age.pow(10).add(BigDecimal.ONE));
        return Math.random() < divide(ageFactor, BigDecimal.valueOf(7)).doubleValue();
    }
}
