package de.idrinth.gods_and_heroes.implementation;

import java.math.BigDecimal;
import java.util.List;

import de.idrinth.gods_and_heroes.abstracts.AbstractQuest;
import de.idrinth.gods_and_heroes.interfaces.Option;

public class SetbackQuest extends AbstractQuest {
    private BigDecimal setbackAmount;
    private double chance;
    
    public SetbackQuest(BigDecimal renown, List<Option> options, double chance, BigDecimal setbackAmount) {
        super(renown, options);
        this.setbackAmount = setbackAmount;
        this.chance = chance;
    }

    @Override
    public boolean addProgress(BigDecimal amount) {
        if(Math.random()*chance < chance) { progress.subtract(setbackAmount);}
        if(options.size() != 1) {
            return false;
        }
        progress = progress.add(amount);
        return isDone();
    }
}