package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Person;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModifiableObservablePersonListTest {
    @Test
    public void testGet() {
        System.out.println("get");
        ModifiableObservablePersonList instance = new ModifiableObservablePersonList();
        instance.add(new PersonMock());
        assertNotEquals(null, instance.get(0));
    }

    @Test
    public void testSize() {
        System.out.println("size");
        ModifiableObservablePersonList instance = new ModifiableObservablePersonList();
        assertEquals(0, instance.size());
        instance.add(new PersonMock());
        assertEquals(1, instance.size());
        assertNotNull(instance.set(0, new PersonMock()));
        instance.remove(0);
        assertEquals(0, instance.size());
    }
    private class PersonMock implements Person {
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
