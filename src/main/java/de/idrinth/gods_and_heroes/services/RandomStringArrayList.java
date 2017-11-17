package de.idrinth.gods_and_heroes.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

class RandomStringArrayList extends ArrayList<String> {
    public RandomStringArrayList() {
        super();
    }
    public RandomStringArrayList(Collection<? extends String> clctn) {
        super(clctn);
    }
    public RandomStringArrayList(File linebreakList) {
        super();
        try {
            addAll((List<String>) FileUtils.readLines(linebreakList, "ascii"));
            this.remove(0);
        } catch (IOException ex) {
            Logger.getLogger(RandomStringArrayList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String get() {
        return get((int) Math.floor(Math.random()*size()));
    }
}
