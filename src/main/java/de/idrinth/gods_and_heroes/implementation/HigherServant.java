package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import java.math.BigDecimal;
import java.math.RoundingMode;

abstract class HigherServant extends Servant implements Priest {
    protected final God god;

    public HigherServant(God god) {
        this.god = god;
    }
    @Override
    public BigDecimal getLevel() {
        return level.setScale(0, RoundingMode.FLOOR);
    }

    @Override
    public void addExperience(BigDecimal experience) {
        level = level.add(
            divide(
                experience,
                BigDecimal.ONE.add(getLevel().pow(2)).multiply(BigDecimal.valueOf(100))
            )
        );
    }
    

    @Override
    public God getGod() {
        return god;
    }

    @Override
    public void processIdle() {
        super.processIdle();
        if(isDead) {
            return;
        }
        if(Math.random()<0.001*getLevel().intValue()) {
            god.addBeliever();
        }
        if(Math.random()<0.1) {
            addExperience(BigDecimal.ONE);
        }
    }
}
