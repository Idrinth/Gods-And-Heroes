package de.idrinth.gods_and_heroes.interfaces;

import java.math.BigDecimal;

public interface Wonder {
    public Alignment getAlignmentShift();
    public BigDecimal getBelieveCost();
    public BigDecimal getRenownReward();
}
