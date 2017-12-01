package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Mortal;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntryListTest {
    @Test
    public void testGet() {
        System.out.println("get");
        EntryList instance = new EntryList();
        instance.add(new MockEntry());
        assertFalse(instance.isEmpty());
        assertNotNull(instance.get(0));
    }

    @Test
    public void testSize() {
        System.out.println("size");
        EntryList instance = new EntryList();
        instance.add(new MockEntry());
        assertFalse(instance.isEmpty());
        assertEquals(1, instance.size());
        instance.add(new MockEntry());
        assertEquals(2, instance.size());
    }
    private class MockEntry extends Entry {
        public MockEntry() {
            super(new MortalImpl(), "A");
        }
    }
    private class MortalImpl implements Mortal {
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
            return new AlignmentImpl();
        }

        @Override
        public String getName() {
            return "A";
        }

        @Override
        public void processIdle() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    private class AlignmentImpl implements Alignment {
        @Override
        public String toString() {
            return "One";
        }
        @Override
        public BigDecimal getIndividuality() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getCollectivism() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getCreation() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getDestruction() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getHonesty() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getFalsehood() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void merge(Alignment alignment) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
