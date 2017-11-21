package de.idrinth.gods_and_heroes.interfaces;

import java.math.BigDecimal;

public interface Believer extends Mortal{
    public boolean isLeaving();
    public boolean isLeaving(BigDecimal renown);
}
