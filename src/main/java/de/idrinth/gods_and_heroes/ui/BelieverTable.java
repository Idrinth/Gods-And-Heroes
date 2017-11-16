package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.Believer;
import de.idrinth.gods_and_heroes.interfaces.God;
import javafx.collections.ObservableList;

public class BelieverTable extends PersonTable<Believer> {
    @Override
    protected ObservableList getList(God god) {
        return god.getBelievers();
    }
}
