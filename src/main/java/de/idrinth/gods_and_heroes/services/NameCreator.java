package de.idrinth.gods_and_heroes.services;

import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class NameCreator {
    private static final RandomStringArrayList FIRST = new RandomStringArrayList(FileUtils.toFile(NameCreator.class.getResource("/names/CSV_Database_of_First_Names.csv")));
    private static final RandomStringArrayList LAST = new RandomStringArrayList(FileUtils.toFile(NameCreator.class.getResource("/names/CSV_Database_of_Last_Names.csv")));
    public static String generate() {
        ArrayList<String> parts = new ArrayList<>();
        for(int i= (int) Math.ceil(Math.random()*3);i>=0;i--) {
            parts.add(FIRST.get());
        }
        parts.add(LAST.get()+(Math.random()<0.2?"-"+LAST.get():""));
        return String.join(" ", parts);
    }
}
