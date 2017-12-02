package de.idrinth.gods_and_heroes.implementation;

import java.math.BigDecimal;
import java.util.List;
import de.idrinth.gods_and_heroes.abstracts.AbstractQuest;
import de.idrinth.gods_and_heroes.interfaces.Option;

public class FailQuest extends AbstractQuest {
	/**
	 * The chance that positive progress is added to the total progress.
	 */
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
    	return (Math.random()*100.0 < chance) ? false : super.addProgress(amount);
    }
}
