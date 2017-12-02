package de.idrinth.gods_and_heroes.abstracts;

import java.math.BigDecimal;
import java.util.List;

import de.idrinth.gods_and_heroes.interfaces.Option;
import de.idrinth.gods_and_heroes.interfaces.Quest;

public abstract class AbstractQuest implements Quest {
    private final BigDecimal renown;
    protected BigDecimal progress = BigDecimal.ZERO;
    protected final List<Option> options;
    
    public AbstractQuest(BigDecimal renown, List<Option> options) {
        this.renown = renown;
        this.options = options;
    }

    @Override
    public BigDecimal getRenownReward() {
        return renown;
    }

    @Override
    public List<Option> getOptions() {
        return options;
    }

    @Override
    public void chooseOption(Option option) {
        options.clear();
        options.add(option);
    }

    @Override
    public Option getChosenOption() {
         return options.get(0);
    }

    @Override
    public boolean isReady() {
         return options.size() == 1;
    }

    @Override
    public boolean isDone() {
         return progress.compareTo(renown.multiply(BigDecimal.TEN)) >= 0;
    }

    @Override
    public abstract boolean addProgress(BigDecimal amount);
}