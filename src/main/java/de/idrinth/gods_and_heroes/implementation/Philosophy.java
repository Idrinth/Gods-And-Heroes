package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import java.math.BigDecimal;

public class Philosophy implements Alignment {
    private BigDecimal individuality = BigDecimal.ZERO;
    private BigDecimal collectivism = BigDecimal.ZERO;
    private BigDecimal creation = BigDecimal.ZERO;
    private BigDecimal destruction = BigDecimal.ZERO;
    private BigDecimal falsehood = BigDecimal.ZERO;
    private BigDecimal honesty = BigDecimal.ZERO;

    public Philosophy(BigDecimal individuality, BigDecimal collectivism, BigDecimal creation, BigDecimal destruction, BigDecimal falsehood, BigDecimal honesty) {
        this.individuality = individuality;
        this.collectivism = collectivism;
        this.creation = creation;
        this.destruction = destruction;
        this.falsehood = falsehood;
        this.honesty = honesty;
        this.merge(new Philosophy());
    }

    public Philosophy() {
        // all as zero
    }

    @Override
    public BigDecimal getIndividuality() {
        return individuality;
    }

    @Override
    public BigDecimal getCollectivism() {
        return collectivism;
    }

    @Override
    public BigDecimal getCreation() {
        return creation;
    }

    @Override
    public BigDecimal getDestruction() {
        return destruction;
    }

    @Override
    public BigDecimal getFalsehood() {
        return falsehood;
    }

    @Override
    public BigDecimal getHonesty() {
        return honesty;
    }

    @Override
    public final void merge(Alignment alignment) {
        collectivism = collectivism.add(alignment.getCollectivism());
        individuality = individuality.add(alignment.getIndividuality()); 
        collectivism = getPositive(collectivism.subtract(individuality));
        individuality = getPositive(individuality.subtract(collectivism));
        
        creation = creation.add(alignment.getCreation());
        destruction = destruction.add(alignment.getDestruction()); 
        creation = getPositive(creation.subtract(individuality));
        destruction = getPositive(destruction.subtract(creation));
        
        falsehood = falsehood.add(alignment.getFalsehood());
        honesty = honesty.add(alignment.getHonesty()); 
        falsehood = getPositive(falsehood.subtract(honesty));
        honesty = getPositive(honesty.subtract(falsehood));
    }
    private BigDecimal getPositive(BigDecimal value) {
        return value.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : value;
    }
}
