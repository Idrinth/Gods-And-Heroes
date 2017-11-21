package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Mortal;
import de.idrinth.gods_and_heroes.services.NameCreator;
import java.math.BigDecimal;
import java.math.RoundingMode;

abstract class Servant implements Mortal {
    protected BigDecimal level = BigDecimal.ONE;
    protected BigDecimal age = BigDecimal.ZERO;
    protected boolean isDead = false;
    protected Alignment alignment;
    protected final String name;

    public Servant() {
        this(Philosophy.getRandom(), NameCreator.generate());
    }

    public Servant(Alignment alignment, String name) {
        this.alignment = alignment;
        this.name = name;
    }

    protected abstract BigDecimal getDeathFactor();

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
    @Override
    public int getAge() {
        return divide(age,BigDecimal.valueOf(1500)).intValue()+15;
    }

    @Override
    public void processIdle() {
        age = age.add(BigDecimal.ONE);
        isDead = age.compareTo(level.multiply(BigDecimal.valueOf(5000)).add(BigDecimal.valueOf(500000)))>=0;
    }
    protected BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        return dividend.divide(divisor, 128, RoundingMode.HALF_UP);
    }
}
