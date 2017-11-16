package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.implementation.ModifiableObservablePersonList;
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
import org.junit.Ignore;

@Ignore
public class PriestTableTest {
    @Test
    public void testSetItems() {
        System.out.println("setItems");
        PriestTable instance = new PriestTable();
        assertEquals(0, instance.getItems().size());
        instance.setItems(new GodMock());
        assertEquals(2, instance.getItems().size());
    }
    private class PriestMock implements Priest {
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

        @Override
        public void addTask(Wonder wonder) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public God getGod() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public BigDecimal getLevel() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addExperience(BigDecimal experience) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }
    private class GodMock implements God {
        @Override
        public BigDecimal getBelieve() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ObservableList<Believer> getBelievers() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            ObservableList<Priest> l = new ModifiableObservablePersonList();
            l.add(new PriestMock());
            l.add(new PriestMock());
            return l;
        }

        @Override
        public BigDecimal getLevel() {
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
        public String getName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void processIdle() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
