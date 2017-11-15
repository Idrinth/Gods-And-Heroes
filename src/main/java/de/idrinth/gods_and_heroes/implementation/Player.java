package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Believer;
import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Hero;
import de.idrinth.gods_and_heroes.interfaces.Mortal;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import de.idrinth.gods_and_heroes.interfaces.Wonder;
import de.idrinth.gods_and_heroes.services.Rounding;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Player implements God {

    private final String name;
    private double believe = 0;
    private double renown = 0;
    private double level = 1;
    private int souls = 1;
    private final Alignment alignment;
    private final ArrayList<Hero> heroes = new ArrayList<>();
    private final ArrayList<Priest> priests = new ArrayList<>();
    private final ArrayList<Believer> believers = new ArrayList<>();

    public Player(String name, Alignment alignment) {
        this.name = name;
        this.alignment = alignment;
    }

    @Override
    public int getBelieve() {
        return (int) Rounding.floor(believe);
    }

    @Override
    public int getRenown() {
        return (int) Rounding.ceil(renown);
    }

    @Override
    public boolean createWonder(Wonder wonder) {
        if (believe < wonder.getBelieveCost()) {
            return false;
        }
        renown += wonder.getRenownReward();
        alignment.merge(wonder.getAlignmentShift());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return (int) Rounding.floor(level);
    }

    @Override
    public void processIdle() {
        believe += 0.00001 * souls;
        renown -= 0.00001;
        heroes.removeIf(new DeadCheck());
        for (Hero hero : heroes) {
            believe += 0.001;
            renown += hero.getLevel() / 100;
        }
        priests.removeIf(new DeadCheck());
        for (Priest priest : priests) {
            believe -= 0.1;
            renown += priest.getLevel() / 100000;
            //chance to add new believer
        }
        believers.removeIf(new LeavingCheck());
        believers.removeIf(new DeadCheck());
        believe += 0.00025*believers.size();
        renown = renown < 0 ? 0 : renown;
        believe = believe < 0 ? 0 : believe;
    }

    @Override
    public void addExperience(int experience) {
        level += experience / (100 + 100 * Math.pow(getLevel(), 1.5));
    }

    @Override
    public List<Believer> getBelievers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private class DeadCheck implements Predicate<Mortal> {
        @Override
        public boolean test(Mortal t) {
            if(!t.isDead()) {
                return false;
            }
            believe += t.getOnDeathBelieve();
            renown += t.getOnDeathRenown();
            souls += t.getOnDeathSouls();
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
