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
        BigDecimal ci = collectivism.add(alignment.getCollectivism()).subtract(individuality).subtract(alignment.getIndividuality());
        BigDecimal cd = creation.add(alignment.getCreation()).subtract(destruction).subtract(alignment.getDestruction());
        BigDecimal fh = falsehood.add(alignment.getFalsehood()).subtract(honesty).subtract(alignment.getHonesty());
        
        collectivism = ci.compareTo(BigDecimal.ZERO) < 0?BigDecimal.ZERO:ci;
        individuality = ci.compareTo(BigDecimal.ZERO) > 0?BigDecimal.ZERO:ci.negate();
        
        creation = cd.compareTo(BigDecimal.ZERO) < 0?BigDecimal.ZERO:cd;
        destruction = cd.compareTo(BigDecimal.ZERO) > 0?BigDecimal.ZERO:cd.negate();
        
        falsehood = fh.compareTo(BigDecimal.ZERO) < 0?BigDecimal.ZERO:fh;
        honesty = fh.compareTo(BigDecimal.ZERO) > 0?BigDecimal.ZERO:fh.negate();
        
    }
}
