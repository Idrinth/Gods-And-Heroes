package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Person;
import java.util.ArrayList;
import javafx.collections.ModifiableObservableListBase;

public class ModifiableObservablePersonList<Q extends Person> extends ModifiableObservableListBase<Q> {
    private final ArrayList<Q> list = new ArrayList<>();

    @Override
    public Q get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected void doAdd(int index, Q element) {
        list.add(index, element);
    }

    @Override
    protected Q doSet(int index, Q element) {
        return list.set(index, element);
    }

    @Override
    protected Q doRemove(int index) {
        return list.remove(index);
    }

}
