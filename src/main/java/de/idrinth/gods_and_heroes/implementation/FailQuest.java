package de.idrinth.gods_and_heroes.implementation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import de.idrinth.gods_and_heroes.abstracts.AbstractQuest;
import de.idrinth.gods_and_heroes.interfaces.Option;
import de.idrinth.gods_and_heroes.interfaces.Quest;

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
        if(options.size() != 1 || Math.random()*chance >= chance  ) {
            return false;
        }
        progress = progress.add(amount);
        return isDone();
    }
}
