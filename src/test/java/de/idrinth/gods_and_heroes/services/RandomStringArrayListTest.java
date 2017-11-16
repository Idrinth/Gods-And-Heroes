package de.idrinth.gods_and_heroes.services;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomStringArrayListTest {
    @Test
    public void testGet() {
        System.out.println("get");
        RandomStringArrayList instance = new RandomStringArrayList();
        instance.add("1");
        instance.add("2");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 0);
        map.put("2", 0);
        for(int i=0;i<1000000;i++) {
            String key = instance.get();
            map.put(key, map.get(key)+1);
        }
        assertTrue(map.get("1")<600000);
        assertTrue(map.get("2")<600000);
    }
    
}
