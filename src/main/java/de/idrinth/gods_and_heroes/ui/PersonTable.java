package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Person;
import javafx.collections.ObservableList;

abstract public class PersonTable<Q extends Person> extends ExtTableView<Q> {
    public PersonTable() {
        super();
        addColumn("Name", 1.5);
        addColumn("Alignment", 3.5);
        addColumn("Age", 0.5);
    }
    public void setItems(God god) {
        super.setItems(getList(god));
    }
    protected abstract ObservableList getList(God god);
}
