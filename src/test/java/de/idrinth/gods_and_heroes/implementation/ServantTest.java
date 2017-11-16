package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServantTest {
    @Test
    public void testGetOnDeathRenown() {
        System.out.println("getOnDeathRenown");
        MockServant instance = new MockServant();
        assertTrue(BigDecimal.valueOf(5).compareTo(instance.getOnDeathRenown()) == 0);
        instance.setAge(BigDecimal.TEN);
        assertTrue(BigDecimal.valueOf(5).compareTo(instance.getOnDeathRenown()) == 0);
    }

    @Test
    public void testGetOnDeathSouls() {
        System.out.println("getOnDeathSouls");
        MockServant instance = new MockServant();
        assertTrue(BigDecimal.ONE.compareTo(instance.getOnDeathSouls()) == 0);
        instance.setAge(BigDecimal.TEN);
        assertTrue(BigDecimal.ONE.compareTo(instance.getOnDeathSouls()) == 0);
    }

    @Test
    public void testGetOnDeathBelieve() {
        System.out.println("getOnDeathBelieve");
        MockServant instance = new MockServant();
        assertTrue(BigDecimal.valueOf(100).compareTo(instance.getOnDeathBelieve()) == 0);
        instance.setAge(BigDecimal.TEN);
        assertTrue(BigDecimal.valueOf(110).compareTo(instance.getOnDeathBelieve()) == 0);
    }

    @Test
    public void testIsDead() {
        System.out.println("isDead");
        Servant instance = new MockServant();
        assertFalse(instance.isDead());
        for(int i=0;i<27000; i++) {
            instance.processIdle();
        }
        assertTrue(instance.isDead());
    }

    @Test
    public void testGetAlignment() {
        System.out.println("getAlignment");
        Servant instance = new MockServant();
        assertTrue(Alignment.class.isInstance(instance.getAlignment()));
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Servant instance = new MockServant();
        assertFalse(instance.getName().isEmpty());
    }

    @Test
    public void testProcessIdle() {
        System.out.println("processIdle");
        MockServant instance = new MockServant();
        assertTrue(instance.getAge().compareTo(BigDecimal.ZERO) == 0);
        instance.processIdle();
        assertTrue(instance.getAge().compareTo(BigDecimal.ONE) == 0);
    }

    private class MockServant extends Servant {
        @Override
        protected BigDecimal getDeathFactor() {
            return BigDecimal.ONE;
        }
        public BigDecimal getAge() {
            return age;
        }
        public void setAge(BigDecimal age) {
            this.age = age;
        }
    }
}
