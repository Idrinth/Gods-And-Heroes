package de.idrinth.gods_and_heroes.services;

import de.idrinth.gods_and_heroes.implementation.ModifiableObservablePersonList;
import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Believer;
import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Hero;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import de.idrinth.gods_and_heroes.interfaces.Quest;
import de.idrinth.gods_and_heroes.interfaces.Wonder;
import java.math.BigDecimal;
import javafx.collections.ObservableList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskHandlerTest {
    @Test
    public void testRun() {
        System.out.println("run");
        TaskedCreature creature = new TaskedCreature();
        TaskHandler instance = new TaskHandler(creature);
        instance.run();
        assertEquals(3, creature.ran());
    }
    private class TaskedCreature implements God,Priest,Hero {
        private int wasRun = 0;
        public int ran() {
            return wasRun;
        }
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
            ModifiableObservablePersonList<Hero> l = new ModifiableObservablePersonList<>();
            l.add(this);
            return l;
        }

        @Override
        public ObservableList<Priest> getPriests() {
            ModifiableObservablePersonList<Priest> l = new ModifiableObservablePersonList<>();
            l.add(this);
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
            wasRun++;
        }

        @Override
        public God getGod() {
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
        public void addTask(Quest quest) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addBeliever() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getAge() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
}
}
