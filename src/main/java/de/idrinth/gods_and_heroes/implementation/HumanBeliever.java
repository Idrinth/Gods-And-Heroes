package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Believer;
import java.math.BigDecimal;

public class HumanBeliever extends Servant implements Believer {
    @Override
    protected BigDecimal getDeathFactor() {
        return BigDecimal.valueOf(0.1);
    }

    @Override
    public boolean isLeaving(BigDecimal renown) {
        BigDecimal ageFactor = divide(BigDecimal.ONE, age.add(BigDecimal.ONE).pow(10));
        BigDecimal renownFactor = BigDecimal.valueOf(0.777).multiply(BigDecimal.valueOf(1000).add(renown));
        return Math.random() < divide(ageFactor, renownFactor).doubleValue();
    }

    @Override
    public boolean isLeaving() {
        return isLeaving(BigDecimal.ZERO);
    }
}
