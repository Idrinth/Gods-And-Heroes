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
        System.out.println(level);
        System.out.println(level.setScale(0, RoundingMode.FLOOR));
        return level.setScale(0, RoundingMode.FLOOR);
    }

    @Override
    public void addExperience(BigDecimal experience) {
        level = level.add(
                experience.divide(
                        BigDecimal.ONE.add(getLevel().pow(2)).multiply(BigDecimal.valueOf(100)),
                        10,
                        RoundingMode.DOWN
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
            god.getBelievers().add(new HumanBeliever());
        }
    }
}
