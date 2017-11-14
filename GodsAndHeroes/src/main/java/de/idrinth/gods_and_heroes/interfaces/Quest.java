package de.idrinth.gods_and_heroes.interfaces;

import java.util.List;

public interface Quest {
    public int getBelieveCost();
    public int getRenownReward();
    public List<Option> getOptions();
    public void chooseOption(Option option);
    public Option getChosenOption();
    public boolean isReady();
}
