package de.idrinth.gods_and_heroes.interfaces;

import java.math.BigDecimal;

public interface Alignment {
    public BigDecimal getIndividuality();
    public BigDecimal getCollectivism();
    public BigDecimal getCreation();
    public BigDecimal getDestruction();
    public BigDecimal getHonesty();
    public BigDecimal getFalsehood();
    public void merge(Alignment alignment);
}
