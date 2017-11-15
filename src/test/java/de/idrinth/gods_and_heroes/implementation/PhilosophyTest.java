package de.idrinth.gods_and_heroes.implementation;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

public class PhilosophyTest {

    @Test
    public void testPhilosophy() {
        System.out.println("getIndividuality");
        Philosophy instance = new Philosophy();
        assertTrue(BigDecimal.ZERO.compareTo(instance.getIndividuality()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance.getCollectivism()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance.getCreation()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance.getDestruction()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance.getFalsehood()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance.getHonesty()) == 0);

        Philosophy instance2 = new Philosophy(BigDecimal.valueOf(2), BigDecimal.ZERO, BigDecimal.valueOf(44), BigDecimal.ZERO, BigDecimal.valueOf(7), BigDecimal.ZERO);
        assertTrue(BigDecimal.valueOf(2).compareTo(instance2.getIndividuality()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance2.getCollectivism()) == 0);
        assertTrue(BigDecimal.valueOf(44).compareTo(instance2.getCreation()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance2.getDestruction()) == 0);
        assertTrue(BigDecimal.valueOf(7).compareTo(instance2.getFalsehood()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance2.getHonesty()) == 0);

        Philosophy instance3 = new Philosophy(BigDecimal.ZERO, BigDecimal.valueOf(2), BigDecimal.ZERO, BigDecimal.valueOf(44), BigDecimal.ZERO, BigDecimal.valueOf(7));
        assertTrue(BigDecimal.ZERO.compareTo(instance3.getIndividuality()) == 0);
        assertTrue(BigDecimal.valueOf(2).compareTo(instance3.getCollectivism()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance3.getCreation()) == 0);
        assertTrue(BigDecimal.valueOf(44).compareTo(instance3.getDestruction()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance3.getFalsehood()) == 0);
        assertTrue(BigDecimal.valueOf(7).compareTo(instance3.getHonesty()) == 0);

        Philosophy instance4 = new Philosophy(BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(-8), BigDecimal.valueOf(44), BigDecimal.valueOf(10), BigDecimal.valueOf(7));
        assertTrue(BigDecimal.ZERO.compareTo(instance4.getIndividuality()) == 0);
        assertTrue(BigDecimal.valueOf(1).compareTo(instance4.getCollectivism()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance4.getCreation()) == 0);
        assertTrue(BigDecimal.valueOf(52).compareTo(instance4.getDestruction()) == 0);
        assertTrue(BigDecimal.valueOf(3).compareTo(instance4.getFalsehood()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance4.getHonesty()) == 0);
    }

    @Test
    public void testMerge() {
        System.out.println("merge");

        Philosophy instance1 = new Philosophy(BigDecimal.ZERO, BigDecimal.valueOf(2), BigDecimal.ZERO, BigDecimal.valueOf(44), BigDecimal.ZERO, BigDecimal.valueOf(7));
        Philosophy instance2 = new Philosophy(BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(-8), BigDecimal.valueOf(44), BigDecimal.valueOf(10), BigDecimal.valueOf(7));
        instance2.merge(instance1);
        
        assertTrue(BigDecimal.ZERO.compareTo(instance2.getIndividuality()) == 0);
        assertTrue(BigDecimal.valueOf(3).compareTo(instance2.getCollectivism()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance2.getCreation()) == 0);
        assertTrue(BigDecimal.valueOf(96).compareTo(instance2.getDestruction()) == 0);
        assertTrue(BigDecimal.ZERO.compareTo(instance2.getFalsehood()) == 0);
        assertTrue(BigDecimal.valueOf(4).compareTo(instance2.getHonesty()) == 0);
        
        
    }
    
}
