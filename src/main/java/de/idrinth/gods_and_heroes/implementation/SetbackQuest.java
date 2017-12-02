package de.idrinth.gods_and_heroes.implementation;

import java.math.BigDecimal;
import java.util.List;

import de.idrinth.gods_and_heroes.abstracts.AbstractQuest;
import de.idrinth.gods_and_heroes.interfaces.Option;

public class SetbackQuest extends AbstractQuest {
	/**
	 * The negative amount of progress which is subtracted from the total quest progress.
	 */
    private BigDecimal setbackAmount;
	/**
	 * The chance that positive progress is added to the total progress.
	 */
    private double chance;
    
    public SetbackQuest(BigDecimal renown, List<Option> options, double chance, BigDecimal setbackAmount) {
        super(renown, options);
        this.setbackAmount = setbackAmount;
        this.chance = chance;
    }

    @Override
    public boolean addProgress(BigDecimal amount) {
        return (Math.random()*100.0 < chance)? super.addProgress(setbackAmount):super.addProgress(amount);
    }
}