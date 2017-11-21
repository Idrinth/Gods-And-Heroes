package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Believer;
import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Hero;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import de.idrinth.gods_and_heroes.interfaces.Quest;
import de.idrinth.gods_and_heroes.interfaces.Wonder;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testGetBelieve() {
        System.out.println("getBelieve");
        Player instance = new Player("Test", new EmptyAlignment());
        assertTrue(BigDecimal.ZERO.compareTo(instance.getBelieve()) == 0);
    }

    @Test
    public void testGetRenown() {
        System.out.println("getRenown");
        Player instance = new Player("Test", new EmptyAlignment());
        assertTrue(BigDecimal.ZERO.compareTo(instance.getRenown()) == 0);
        assertTrue(instance.createWonder(new EmptyWonder(0,100)));
        assertTrue(BigDecimal.valueOf(100).compareTo(instance.getRenown()) == 0);
        assertFalse(instance.createWonder(new EmptyWonder(10,100)));
        assertTrue(BigDecimal.valueOf(100).compareTo(instance.getRenown()) == 0);
    }

    @Test
    public void testCreateWonder() {
        System.out.println("getRenown");
        Player instance = new Player("Test", new EmptyAlignment());
        instance.createWonder(new EmptyWonder(0,100));
        assertTrue(instance.createWonder(new EmptyWonder(0,100)));
        assertFalse(instance.createWonder(new EmptyWonder(10,100)));
    }

    @Test
    public void testGetHeroes() {
        System.out.println("getHeroes");
        Player instance = new Player("Test", new EmptyAlignment());
        assertEquals(0, instance.getHeroes().size());
        instance.getHeroes().add(new EmptyCreature());
        assertEquals(1, instance.getHeroes().size());
    }

    @Test
    public void testGetPriests() {
        System.out.println("getPriests");
        Player instance = new Player("Test", new EmptyAlignment());
        assertEquals(0, instance.getPriests().size());
        instance.getPriests().add(new EmptyCreature());
        assertEquals(1, instance.getPriests().size());
    }

    @Test
    public void testGetAlignment() {
        System.out.println("getAlignment");
        Player instance = new Player("Test", new EmptyAlignment());
        assertTrue(Alignment.class.isInstance(instance.getAlignment()));
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals("Test", new Player("Test", new EmptyAlignment()).getName());
        assertEquals("Test2", new Player("Test2", new EmptyAlignment()).getName());
    }

    @Test
    public void testGetLevelAndAddExperience() {
        System.out.println("getLevel + addExperience");
        Player instance = new Player("Test", new EmptyAlignment());
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
    public void testProcessIdleDeath() {
        //Hero
        Player instance = new Player("Test", new EmptyAlignment());
        instance.getHeroes().add(new EmptyCreature(true));
        assertEquals(1, instance.getHeroes().size());
        instance.processIdle();
        assertTrue(BigDecimal.valueOf(10).compareTo(instance.getBelieve()) == 0);
        assertTrue(BigDecimal.valueOf(3).compareTo(instance.getRenown()) == 0);
        assertEquals(0, instance.getHeroes().size());
        //Believer
        Player instance2 = new Player("Test", new EmptyAlignment());
        instance2.getBelievers().add(new EmptyCreature(true));
        assertEquals(1, instance2.getBelievers().size());
        instance2.processIdle();
        assertTrue(BigDecimal.valueOf(10).compareTo(instance2.getBelieve()) == 0);
        assertTrue(BigDecimal.valueOf(3).compareTo(instance2.getRenown()) == 0);
        assertEquals(0, instance2.getBelievers().size());

        Player instance4 = new Player("Test", new EmptyAlignment());
        instance4.getBelievers().add(new EmptyCreature(false, true));
        assertEquals(1, instance4.getBelievers().size());
        instance4.processIdle();
        assertTrue(BigDecimal.ZERO.compareTo(instance4.getBelieve()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance4.getRenown()) == 0);
        assertEquals(0, instance4.getBelievers().size());

        Player instance3 = new Player("Test", new EmptyAlignment());
        instance3.getBelievers().add(new EmptyCreature(true, true));
        assertEquals(1, instance3.getBelievers().size());
        instance3.processIdle();
        assertTrue(BigDecimal.ZERO.compareTo(instance3.getBelieve()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance3.getRenown()) == 0);
        assertEquals(0, instance3.getBelievers().size());
        //Priest
        Player instance5 = new Player("Test", new EmptyAlignment());
        instance5.getPriests().add(new EmptyCreature(true));
        assertEquals(1, instance5.getPriests().size());
        instance5.processIdle();
        assertTrue(BigDecimal.TEN.compareTo(instance5.getBelieve()) == 0);
        assertTrue(BigDecimal.valueOf(3).compareTo(instance5.getRenown()) == 0);
        assertEquals(0, instance5.getPriests().size());
    }
    @Test
    public void testProcessIdle() {
        System.out.println("processIdle");
        //Empty
        Player instance = new Player("Test", new EmptyAlignment());
        assertTrue(BigDecimal.ZERO.compareTo(instance.getBelieve()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance.getRenown()) == 0);
        for(int i=0;i<100000;i++) {
            instance.processIdle();
        }
        assertTrue(BigDecimal.ONE.compareTo(instance.getBelieve()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance.getRenown()) == 0);
        //Believers
        Player instance4 = new Player("Test", new EmptyAlignment());
        instance4.getBelievers().add(new EmptyCreature());
        for(int i=0;i<100000;i++) {
            instance4.processIdle();
        }
        assertTrue(BigDecimal.valueOf(2501).compareTo(instance4.getBelieve()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance4.getRenown()) == 0);
        //Heroes
        Player instance2 = new Player("Test", new EmptyAlignment());
        instance2.getHeroes().add(new EmptyCreature());
        for(int i=0;i<1000;i++) {
            instance2.processIdle();
        }
        assertTrue(BigDecimal.ONE.compareTo(instance2.getBelieve()) == 0);
        assertTrue(BigDecimal.TEN.compareTo(instance2.getRenown()) == 0);
        //Priests
        Player instance3 = new Player("Test", new EmptyAlignment());
        instance3.getPriests().add(new EmptyCreature());
        for(int i=0;i<10000;i++) {
            instance3.processIdle();
        }
        assertTrue(BigDecimal.ZERO.compareTo(instance3.getBelieve()) == 0);
        assertTrue(BigDecimal.ONE.compareTo(instance3.getRenown()) == 0);
    }

    @Test
    public void testGetBelievers() {
        System.out.println("add & getBelievers");
        Player instance = new AutoListGod("Test", new EmptyAlignment());
        assertEquals(0, instance.getBelievers().size());
        instance.getBelievers().add(new EmptyCreature());
        assertEquals(1, instance.getBelievers().size());
        instance.addBeliever();
        assertEquals(2, instance.getBelievers().size());
    }
    private class AutoListGod extends Player {
        public AutoListGod(String name, Alignment alignment) {
            super(name, alignment);
        }
        @Override
        public void addBeliever() {
            super.addBeliever();
            cleanLists();
        }
    
    }
    private class EmptyCreature implements Believer,Priest,Hero {
        private final boolean isDead;
        private final boolean isLeaving;
        public EmptyCreature() {
            this(false);
        }
        public EmptyCreature(boolean isDead) {
            this(isDead, false);
        }
        public EmptyCreature(boolean isDead, boolean isLeaving) {
            this.isDead = isDead;
            this.isLeaving = isLeaving;
        }

        @Override
        public boolean isLeaving() {
            return isLeaving;
        }

        @Override
        public boolean isLeaving(BigDecimal bd) {
            return isLeaving;
        }

        @Override
        public BigDecimal getOnDeathRenown() {
            return BigDecimal.valueOf(3);
        }

        @Override
        public BigDecimal getOnDeathSouls() {
            return BigDecimal.ONE;
        }

        @Override
        public BigDecimal getOnDeathBelieve() {
            return BigDecimal.TEN;
        }

        @Override
        public boolean isDead() {
            return isDead;
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
        public God getGod() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getLevel() {
            return BigDecimal.ONE;
        }

        @Override
        public void addExperience(BigDecimal experience) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addTask(Quest quest) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getAge() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    private class EmptyWonder implements Wonder {
        private final int believe;
        private final int renown;

        public EmptyWonder(int believe, int renown) {
            this.believe = believe;
            this.renown = renown;
        }
        @Override
        public Alignment getAlignmentShift() {
            return new EmptyAlignment();
        }

        @Override
        public BigDecimal getBelieveCost() {
            return BigDecimal.valueOf(believe);
        }

        @Override
        public BigDecimal getRenownReward() {
            return BigDecimal.valueOf(renown);
        }
    
    }
    private class EmptyAlignment implements Alignment {

        @Override
        public BigDecimal getIndividuality() {
            return BigDecimal.ZERO;
        }

        @Override
        public BigDecimal getCollectivism() {
            return BigDecimal.ZERO;
        }

        @Override
        public BigDecimal getCreation() {
            return BigDecimal.ZERO;
        }

        @Override
        public BigDecimal getDestruction() {
            return BigDecimal.ZERO;
        }

        @Override
        public BigDecimal getHonesty() {
            return BigDecimal.ZERO;
        }

        @Override
        public BigDecimal getFalsehood() {
            return BigDecimal.ZERO;
        }

        @Override
        public void merge(Alignment alignment) {
            //ignore
        }
    }
}
