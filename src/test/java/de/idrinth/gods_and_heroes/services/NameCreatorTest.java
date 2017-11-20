package de.idrinth.gods_and_heroes.services;

import org.junit.Test;
import static org.junit.Assert.*;

public class NameCreatorTest {
    @Test
    public void testGenerate() {
        System.out.println("generate");
        assertTrue(NameCreator.generate().length() > 0);
    }
}
