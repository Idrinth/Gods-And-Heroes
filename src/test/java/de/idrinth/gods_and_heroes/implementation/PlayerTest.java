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
    
    public PlayerTest() {
    }

    @Test
    public void testGetBelieve() {
        System.out.println("getBelieve");
        Player instance = new Player("Test", new EmptyAlignment());
        assertTrue(BigDecimal.ZERO.equals(instance.getBelieve()));
    }

    @Test
    public void testGetRenown() {
        System.out.println("getRenown");
        Player instance = new Player("Test", new EmptyAlignment());
        assertTrue(BigDecimal.ZERO.equals(instance.getRenown()));
        assertTrue(instance.createWonder(new EmptyWonder(0,100)));
        System.out.println(instance.getRenown());
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
        instance.getHeroes().add(new EmptyHero());
        assertEquals(1, instance.getHeroes().size());
    }

    @Test
    public void testGetPriests() {
        System.out.println("getPriests");
        Player instance = new Player("Test", new EmptyAlignment());
        assertEquals(0, instance.getPriests().size());
        instance.getPriests().add(new EmptyPriest());
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
    public void testProcessIdle() {
        System.out.println("processIdle");
        Player instance = new Player("Test", new EmptyAlignment());
        assertTrue(BigDecimal.ZERO.compareTo(instance.getBelieve()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance.getRenown()) == 0);
        for(int i=0;i<100000;i++) {
            instance.processIdle();
        }
        assertTrue(BigDecimal.ONE.compareTo(instance.getBelieve()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance.getRenown()) == 0);
    }

    @Test
    public void testGetBelievers() {
        System.out.println("getBelievers");
        Player instance = new Player("Test", new EmptyAlignment());
        assertEquals(0, instance.getBelievers().size());
        instance.getBelievers().add(new EmptyBeliever());
        assertEquals(1, instance.getBelievers().size());
    }
    private class EmptyBeliever implements Believer {

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
    }
    private class EmptyPriest implements Priest {

        @Override
        public void addTask(Wonder wonder) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public God getGod() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getLevel() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void processIdle() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addExperience(BigDecimal experience) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Alignment getAlignment() {
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
    }
    private class EmptyHero implements Hero {
        @Override
        public void addTask(Quest quest) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public God getGod() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getLevel() {
            return BigDecimal.ONE;
        }

        @Override
        public void processIdle() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addExperience(BigDecimal experience) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Alignment getAlignment() {
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
            return false;
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
