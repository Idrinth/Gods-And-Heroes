package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Priest;
import javafx.collections.ObservableList;

public class PriestTable extends PersonTable<Priest> {
    @Override
    protected ObservableList getList(God god) {
        return god.getPriests();
    }
    
}
