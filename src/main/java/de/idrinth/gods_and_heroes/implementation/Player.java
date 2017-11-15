package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Believer;
import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Hero;
import de.idrinth.gods_and_heroes.interfaces.Mortal;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import de.idrinth.gods_and_heroes.interfaces.Wonder;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Player implements God {

    private final String name;
    private BigDecimal believe = BigDecimal.ZERO;
    private BigDecimal renown = BigDecimal.ZERO;
    private BigDecimal level = BigDecimal.ONE;
    private BigDecimal souls = BigDecimal.ONE;
    private final Alignment alignment;
    private final ArrayList<Hero> heroes = new ArrayList<>();
    private final ArrayList<Priest> priests = new ArrayList<>();
    private final ArrayList<Believer> believers = new ArrayList<>();
    
    private final static MathContext FLOOR = new MathContext(1,RoundingMode.FLOOR);
    private final static MathContext CEIL = new MathContext(1,RoundingMode.CEILING);

    public Player(String name, Alignment alignment) {
        this.name = name;
        this.alignment = alignment;
    }

    @Override
    public BigDecimal getBelieve() {
        return believe.round(FLOOR);
    }

    @Override
    public BigDecimal getRenown() {
        return renown.round(CEIL);
    }

    @Override
    public boolean createWonder(Wonder wonder) {
        if (believe.compareTo(wonder.getBelieveCost()) < 0) {
            return false;
        }
        believe = believe.subtract(wonder.getBelieveCost());
        renown = renown.add(wonder.getRenownReward());
        alignment.merge(wonder.getAlignmentShift());
        addExperience(wonder.getBelieveCost().divide(BigDecimal.valueOf(100)));
        return true;
    }

    @Override
    public List<Hero> getHeroes() {
        return heroes;
    }

    @Override
    public List<Priest> getPriests() {
        return priests;
    }

    @Override
    public Alignment getAlignment() {
        return alignment;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getLevel() {
        return level.round(FLOOR);
    }

    @Override
    public void processIdle() {
        believe = believe.add(BigDecimal.valueOf(0.00001).multiply(souls));
        renown = renown.subtract(BigDecimal.valueOf(0.00001));
        heroes.removeIf(new DeadCheck());
        for (Hero hero : heroes) {
            believe = believe.add(BigDecimal.valueOf(0.001));
            renown = renown.add(hero.getLevel().divide(BigDecimal.valueOf(100)));
        }
        priests.removeIf(new DeadCheck());
        for (Priest priest : priests) {
            believe = believe.subtract(BigDecimal.valueOf(0.1));
            renown = renown.add(priest.getLevel().divide(BigDecimal.valueOf(10000)));
            //chance to add new believer
        }
        believers.removeIf(new LeavingCheck());
        believers.removeIf(new DeadCheck());
        believe = believe.add(BigDecimal.valueOf(0.00025).multiply(BigDecimal.valueOf(believers.size())));
        renown = renown.max(BigDecimal.ZERO);
        believe = believe.max(BigDecimal.ZERO);
    }

    @Override
    public void addExperience(BigDecimal experience) {
        level = level.add(
                experience.divide(
                        BigDecimal.ONE.add(getLevel().pow(2)).multiply(BigDecimal.valueOf(100))
                )
        );
    }

    @Override
    public List<Believer> getBelievers() {
        return believers;
    }
    private class DeadCheck implements Predicate<Mortal> {
        @Override
        public boolean test(Mortal t) {
            if(!t.isDead()) {
                return false;
            }
            believe = believe.add(t.getOnDeathBelieve());
            renown = renown.add(t.getOnDeathRenown());
            souls = souls.add(t.getOnDeathSouls());
            return true;
        }
    }
    private class LeavingCheck implements Predicate<Believer> {
        @Override
        public boolean test(Believer t) {
            return t.isLeaving();
        }
    }
}
