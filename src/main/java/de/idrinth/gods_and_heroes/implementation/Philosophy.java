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
        BigDecimal ci = calculateGroup(collectivism, alignment.getCollectivism(), individuality, alignment.getIndividuality());
        BigDecimal cd = calculateGroup(creation, alignment.getCreation(), destruction, alignment.getDestruction());
        BigDecimal fh = calculateGroup(falsehood, alignment.getFalsehood(), honesty, alignment.getHonesty());
        
        collectivism = getPositive(ci);
        individuality = getPositive(ci.negate());
        
        creation = getPositive(cd);
        destruction = getPositive(cd.negate());
        
        falsehood = getPositive(fh);
        honesty = getPositive(fh.negate());
    }
    private BigDecimal calculateGroup(BigDecimal element1old, BigDecimal element1new, BigDecimal element2new, BigDecimal element2old) {
        BigDecimal element1 = element1old.add(element1new);
        BigDecimal element2 = element2old.add(element2new);
        return element1.subtract(element2);
    }
    private BigDecimal getPositive(BigDecimal value) {
        return value.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : value;
    }
}
