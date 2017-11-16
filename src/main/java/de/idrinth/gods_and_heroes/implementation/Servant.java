package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Mortal;
import de.idrinth.gods_and_heroes.services.NameCreator;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

abstract class Servant implements Mortal {
    protected BigDecimal level = BigDecimal.ONE;
    protected abstract BigDecimal getDeathFactor();
    protected BigDecimal age = BigDecimal.ZERO;
    protected boolean isDead = false;
    protected Alignment alignment = Philosophy.getRandom();
    protected final String name = NameCreator.generate();
    @Override
    public BigDecimal getOnDeathRenown() {
        return BigDecimal.valueOf(5).multiply(getDeathFactor());
    }

    @Override
    public BigDecimal getOnDeathSouls() {
        return BigDecimal.valueOf(1).multiply(getDeathFactor());
    }

    @Override
    public BigDecimal getOnDeathBelieve() {
        return (BigDecimal.valueOf(100).add(age)).multiply(getDeathFactor());
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public Alignment getAlignment() {
        return alignment;
    }

    @Override
    public String getName() {
        return name;
    }

    protected double getDeathChance() {
        return divide(age.pow(3), level.multiply(BigDecimal.valueOf(27000000))).doubleValue();
    }

    @Override
    public void processIdle() {
        age = age.add(BigDecimal.ONE);
        isDead = getDeathChance()>Math.random();
    }
    protected BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        return dividend.divide(divisor, 128, RoundingMode.HALF_UP);
    }
}
