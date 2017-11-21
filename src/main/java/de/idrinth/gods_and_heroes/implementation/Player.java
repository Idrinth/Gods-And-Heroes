package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Believer;
import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Hero;
import de.idrinth.gods_and_heroes.interfaces.Mortal;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import de.idrinth.gods_and_heroes.interfaces.Wonder;
import de.idrinth.gods_and_heroes.ui.AttributeItem;
import de.idrinth.gods_and_heroes.ui.AttributeList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.function.Predicate;
import javafx.collections.ModifiableObservableListBase;
import javafx.collections.ObservableList;

public class Player implements God,AttributeList {

    private final String name;
    private BigDecimal believe = BigDecimal.ZERO;
    private BigDecimal renown = BigDecimal.ZERO;
    private BigDecimal level = BigDecimal.ONE;
    private BigDecimal souls = BigDecimal.ONE;
    private final Alignment alignment;

    private final ObservableList<Hero> heroes = new ModifiableObservablePersonList<>();
    private final ObservableList<Priest> priests = new ModifiableObservablePersonList<>();
    private final ObservableList<Believer> believers = new ModifiableObservablePersonList<>();
    private final ObservableList<AttributeItem> attributes = new ObservableAttributeList();

    public Player(String name, Alignment alignment) {
        this.name = name;
        this.alignment = alignment;
        attributes.add(new AttributeItem("Name", name));
        updateAttributes();
    }
    private void updateAttributes() {
        attributes.add(new AttributeItem("Believe", believe.toBigInteger()));
        attributes.add(new AttributeItem("Believers", BigInteger.valueOf(believers.size())));
        attributes.add(new AttributeItem("Heroes", BigInteger.valueOf(heroes.size())));
        attributes.add(new AttributeItem("Priests", BigInteger.valueOf(priests.size())));
        attributes.add(new AttributeItem("Renown", renown.toBigInteger()));
        attributes.add(new AttributeItem("Souls", souls.toBigInteger()));
        attributes.add(new AttributeItem("Level", getLevel().toBigInteger()));
    }
    @Override
    public BigDecimal getBelieve() {
        return believe.setScale(0, RoundingMode.FLOOR);
    }

    @Override
    public BigDecimal getRenown() {
        return renown.setScale(0, RoundingMode.CEILING);
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
    public ObservableList<Hero> getHeroes() {
        return heroes;
    }

    @Override
    public ObservableList<Priest> getPriests() {
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
        return level.setScale(0, RoundingMode.FLOOR);
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
        }
        believers.removeIf(new LeavingCheck());
        believers.removeIf(new DeadCheck());
        believe = believe.add(BigDecimal.valueOf(0.00025).multiply(BigDecimal.valueOf(believers.size())));
        renown = renown.max(BigDecimal.ZERO);
        believe = believe.max(BigDecimal.ZERO);
        updateAttributes();
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
    public ObservableList<Believer> getBelievers() {
        return believers;
    }

    @Override
    public ObservableList<AttributeItem> getAttributes() {
        return attributes;
    }

    @Override
    public void addBeliever() {
        believers.add(new HumanBeliever());
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
    private class ObservableAttributeList extends ModifiableObservableListBase<AttributeItem> {
        private final HashMap<String, AttributeItem> map = new HashMap<>();
        private final HashMap<Integer, String> keys = new HashMap<>();
        @Override
        public AttributeItem get(int index) {
            return map.get(keys.get(index));
        }

        @Override
        public int size() {
            return map.size();
        }

        @Override
        protected void doAdd(int index, AttributeItem element) {
            keys.put(index, element.getName());
            map.put(element.getName(), element);
        }

        @Override
        protected AttributeItem doSet(int index, AttributeItem element) {
            keys.put(index, element.getName());
            map.put(element.getName(), element);
            return element;
        }

        @Override
        protected AttributeItem doRemove(int index) {
            AttributeItem element = map.get(keys.get(index));
            keys.remove(index);
            if(!keys.containsValue(element.getName())) {
                map.remove(element.getName());
            }
            return element;
        }
    }
}
