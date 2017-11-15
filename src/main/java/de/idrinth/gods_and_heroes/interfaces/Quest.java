package de.idrinth.gods_and_heroes.interfaces;

import java.math.BigDecimal;
import java.util.List;

public interface Quest {
    public BigDecimal getBelieveCost();
    public BigDecimal getRenownReward();
    public List<Option> getOptions();
    public void chooseOption(Option option);
    public Option getChosenOption();
    public boolean isReady();
}
