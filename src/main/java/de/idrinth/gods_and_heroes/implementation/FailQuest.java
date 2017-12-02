package de.idrinth.gods_and_heroes.implementation;

import java.math.BigDecimal;
import java.util.List;
import de.idrinth.gods_and_heroes.abstracts.AbstractQuest;
import de.idrinth.gods_and_heroes.interfaces.Option;

public class FailQuest extends AbstractQuest {
    private double chance;

    public FailQuest(BigDecimal renown, List<Option> options, double chance) {
        super(renown, options);
        this.chance = chance;
    }
    
    public double getChance() {
        return chance;
    }

    @Override
    public boolean addProgress(BigDecimal amount) {
        if(Math.random()*chance >= chance) {
            return false;
        }
        return super.addProgress(amount);
    }
}
