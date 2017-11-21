package de.idrinth.gods_and_heroes.ui;

import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class AttributeItemTest {

    @Test
    public void testSetValue() {
        System.out.println("getValue + setValue");
        assertEquals("0", new AttributeItem("ZZZ").getValue());
        AttributeItem instance = new AttributeItem("Q", BigInteger.ONE);
        assertEquals("1", instance.getValue());
        instance.setValue(BigInteger.TEN);
        assertEquals("10", instance.getValue());
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals("A", new AttributeItem("A").getName());
        assertEquals("A", new AttributeItem("A", BigInteger.ONE).getName());
        assertEquals("ZZZ", new AttributeItem("ZZZ").getName());
        assertEquals("ZZZ", new AttributeItem("ZZZ", BigInteger.TEN).getName());
    }
}
