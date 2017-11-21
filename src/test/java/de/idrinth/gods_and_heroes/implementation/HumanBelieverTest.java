package de.idrinth.gods_and_heroes.implementation;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class HumanBelieverTest {
    @Test
    public void testIsLeaving() {
        System.out.println("isLeaving");
        HumanBeliever instance = new HumanBeliever();
        HashMap<Boolean, Integer> map = new HashMap<>();
        map.put(true, 0);
        map.put(false, 0);
        for(int i=0;i<1000000;i++) {
            boolean key = instance.isLeaving();
            map.put(key, map.get(key)+1);
        }
        assertTrue(map.get(true)<2400);
        assertTrue(map.get(false)>900000);
    }
}
