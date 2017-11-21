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

    @Override
    public String toString() {
        String parts = "";
        BigDecimal hundred = BigDecimal.valueOf(100);
        if(creation.compareTo(hundred) >= 0) {
            parts += "nurturing";
        } else if(destruction.compareTo(hundred) >= 0) {
            parts += "challenging";
        }
        if(falsehood.compareTo(hundred) >= 0) {
            parts += " Scoundrel";
        } else if(honesty.compareTo(hundred) >= 0) {
            parts += " Knight";
        } else {
            parts += " One";
        }
        if(individuality.compareTo(hundred) >= 0) {
            parts += " of the Wild";
        } else if(collectivism.compareTo(hundred) >= 0) {
            parts += " of the Order";
        }
        return parts.trim();
    }

    public static Alignment getRandom() {
        return new Philosophy(
            BigDecimal.valueOf(Math.random()*1000),
            BigDecimal.valueOf(Math.random()*1000),
            BigDecimal.valueOf(Math.random()*1000),
            BigDecimal.valueOf(Math.random()*1000),
            BigDecimal.valueOf(Math.random()*1000),
            BigDecimal.valueOf(Math.random()*1000)
        );
    }
}
