package de.idrinth.gods_and_heroes.ui;

import java.util.LinkedList;
import java.util.function.Predicate;
import javafx.collections.ModifiableObservableListBase;

public class EntryList extends ModifiableObservableListBase<Entry> {
    private volatile LinkedList<Entry> entries = new LinkedList<>();
    @Override
    public Entry get(int index) {
        return entries.get(index);
    }
    @Override
    public int size() {
        return entries.size();
    }
    @Override
    protected synchronized void doAdd(int index, Entry element) {
        entries.add(index, element);
        entries.removeIf(new EntryFilter());
    }
    @Override
    protected Entry doSet(int index, Entry element) {
        return entries.set(index, element);
    }
    @Override
    protected Entry doRemove(int index) {
        return entries.remove(index);
    }
    private class EntryFilter implements Predicate<Entry> {
        @Override
        public boolean test(Entry t) {
            return t.isExpired();
        }
    }
}