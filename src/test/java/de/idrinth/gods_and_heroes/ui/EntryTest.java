package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Mortal;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntryTest {
    @Test
    public void testIsExpired() throws InterruptedException {
        System.out.println("isExpired");
        Entry instance = new EntryImpl(new MortalImpl("", new AlignmentImpl()), "");
        assertFalse(instance.isExpired());
        Thread.sleep(5500);
        assertTrue(instance.isExpired());
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals("Two", new EntryImpl(new MortalImpl("Two", new AlignmentImpl()), "").getName());
        assertEquals("Tiwo", new EntryImpl(new MortalImpl("Tiwo", new AlignmentImpl()), "").getName());
    }

    @Test
    public void testGetAlignment() {
        System.out.println("getAlignment");
        assertEquals("One", new EntryImpl(new MortalImpl("", new AlignmentImpl()), "").getAlignment());
    }

    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        Alignment a = new AlignmentImpl();
        assertEquals("tst1", new EntryImpl(new MortalImpl("", a), "tst1").getEvent());
        assertEquals("test2", new EntryImpl(new MortalImpl("", a), "test2").getEvent());
    }

    private class EntryImpl extends Entry {
        public EntryImpl(Mortal mortal, String label) {
            super(mortal, label);
        }
    }
    private class MortalImpl implements Mortal {
        private final String name;
        private final Alignment alignment;
        public MortalImpl(String name, Alignment alignment) {
            this.name = name;
            this.alignment = alignment;
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
            return alignment;
        }

        @Override
        public String getName() {
            return name;
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
