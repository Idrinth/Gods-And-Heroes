package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.Mortal;

public class PartingLog extends ExtTableView<Entry> implements PartingHandler {
    private volatile EntryList entries = new EntryList();

    public PartingLog() {
        super();
        setItems(entries);
        addColumn("Event", 0.75);
        addColumn("Name");
        addColumn("Alignment",3.5);
    }

    @Override
    public void addDeathCase(Mortal mortal) {
        entries.add(new DeathEntry(mortal));
    }
    @Override
    public void addLeaveCase(Mortal mortal) {
        entries.add(new LeavingEntry(mortal));
    }
    @Override
    public void addJoinCase(Mortal mortal) {
        entries.add(new JoiningEntry(mortal));
    }
    private class DeathEntry extends Entry {
        public DeathEntry(Mortal mortal) {
            super(mortal, "Death");
        }
    }
    private class LeavingEntry extends Entry {
        public LeavingEntry(Mortal mortal) {
            super(mortal, "Leave");
        }
    }
    private class JoiningEntry extends Entry {
        public JoiningEntry(Mortal mortal) {
            super(mortal, "Join");
        }
    }
}
