package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Hero;
import javafx.collections.ObservableList;

public class HeroTable extends PersonTable<Hero> {
    public HeroTable() {
        super();
        addColumn("Level", 0.5);
    }
    @Override
    protected ObservableList getList(God god) {
        return god.getHeroes();
    }
}
