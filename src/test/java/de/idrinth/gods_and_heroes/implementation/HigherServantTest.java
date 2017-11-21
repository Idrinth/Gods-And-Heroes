package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Believer;
import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Hero;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import de.idrinth.gods_and_heroes.interfaces.Wonder;
import java.math.BigDecimal;
import javafx.collections.ObservableList;
import org.junit.Test;
import static org.junit.Assert.*;

public class HigherServantTest {
    @Test
    public void testGetLevel() {
        System.out.println("getLevel + addExperience");
        HigherServant instance = new HigherServantImpl(new MockGod());
        BigDecimal xp = BigDecimal.valueOf(200);
        assertTrue(BigDecimal.ONE.compareTo(instance.getLevel()) == 0);
        instance.addExperience(xp);
        assertTrue(BigDecimal.valueOf(2).compareTo(instance.getLevel()) == 0);
        instance.addExperience(xp);
        assertTrue(BigDecimal.valueOf(2).compareTo(instance.getLevel()) == 0);
        instance.addExperience(xp);
        assertTrue(BigDecimal.valueOf(2).compareTo(instance.getLevel()) == 0);
        instance.addExperience(xp);
        assertTrue(BigDecimal.valueOf(3).compareTo(instance.getLevel()) == 0);
    }

    @Test
    public void testGetGod() {
        System.out.println("getGod");
        God god = new MockGod();
        HigherServant instance = new HigherServantImpl(god);
        assertTrue(instance.getGod().equals(god));
    }

    @Test
    public void testProcessIdle() {
        System.out.println("processIdle");
        God god = new MockGod();
        assertEquals(0, god.getBelievers().size());
        HigherServant instance = new HigherServantImpl(god, 1000000);
        instance.processIdle();
        assertEquals(1, god.getBelievers().size());
    }

    private class HigherServantImpl extends HigherServant {

        public HigherServantImpl(God god) {
            this(god, 1);
        }
        public HigherServantImpl(God god, long level) {
            super(god);
            this.level = BigDecimal.valueOf(level);
        }

        @Override
        protected BigDecimal getDeathFactor() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    private class MockGod implements God {
        private final ObservableList<Believer> l = new ModifiableObservablePersonList<>();
        @Override
        public BigDecimal getBelieve() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ObservableList<Believer> getBelievers() {
            return l;
        }

        @Override
        public BigDecimal getRenown() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean createWonder(Wonder wonder) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ObservableList<Hero> getHeroes() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ObservableList<Priest> getPriests() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getLevel() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addExperience(BigDecimal experience) {
            //ignore
        }

        @Override
        public Alignment getAlignment() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void processIdle() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addBeliever() {
            l.add(new MockBeliever());
        }

        @Override
        public void addHero() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addPriest() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    private class MockBeliever implements Believer {

        @Override
        public boolean isLeaving() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getOnDeathRenown() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getOnDeathSouls() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getOnDeathBelieve() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isDead() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getAge() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Alignment getAlignment() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void processIdle() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isLeaving(BigDecimal renown) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
