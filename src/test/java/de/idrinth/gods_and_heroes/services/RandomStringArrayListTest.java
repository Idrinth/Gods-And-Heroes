package de.idrinth.gods_and_heroes.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
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

    @Test
    public void testInitializationWithList() throws IOException {
        System.out.println("initialization");
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        assertEquals(3, new RandomStringArrayList(list).size());
        assertEquals(0, new RandomStringArrayList().size());
        assertEquals(0, new RandomStringArrayList(new File("/will/never/exists/I/hope")).size());
        File file = new File("./test");
        FileUtils.writeStringToFile(file, "title\nfirst\nsecond", "ascii");// to be mocked
        assertEquals(2, new RandomStringArrayList(file).size());
    }
}
