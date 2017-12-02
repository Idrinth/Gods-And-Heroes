package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.abstracts.AbstractQuest;
import de.idrinth.gods_and_heroes.interfaces.Option;
import java.math.BigDecimal;
import java.util.List;

public class SimpleQuest extends AbstractQuest {
    public SimpleQuest(BigDecimal renown, List<Option> options) {
    	super(renown, options);
    }

	@Override
	public boolean addProgress(BigDecimal amount) {
        if(options.size() != 1) {
            return false;
        }
        progress = progress.add(amount);
        return isDone();
	}
}