package de.idrinth.gods_and_heroes.services;

import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class NameCreatorTest {
    @Test
    public void testGenerate() {
        System.out.println("generate");
        assertTrue(NameCreator.generate().length() > 0);
    }

    @Test
    public void testGenerateRandomness() {
        System.out.println("generate - randomness check");
        HashSet<String> map = new HashSet<>();
        int found = 0;
        for(int i=0;i<1000;i++) {
            String result = NameCreator.generate();
            found += map.add(result) ? 0 : 1;
        }
        assertTrue(found<10);
    }
}
