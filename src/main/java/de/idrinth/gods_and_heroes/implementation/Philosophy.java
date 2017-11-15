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
        this.adjust();
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

        creation = creation.add(alignment.getCreation());
        destruction = destruction.add(alignment.getDestruction());

        falsehood = falsehood.add(alignment.getFalsehood());
        honesty = honesty.add(alignment.getHonesty());

        adjust();
    }

    private void adjust() {
        BigDecimal ci = collectivism.subtract(individuality);
        collectivism = getPositive(ci);
        individuality = getPositive(ci.negate());

        BigDecimal cd = creation.subtract(destruction);
        creation = getPositive(cd);
        destruction = getPositive(cd.negate());

        BigDecimal fh = falsehood.subtract(honesty);
        falsehood = getPositive(fh);
        honesty = getPositive(fh.negate());
    }

    private BigDecimal getPositive(BigDecimal value) {
        return value.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : value;
    }
}
