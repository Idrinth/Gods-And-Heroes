package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.Mortal;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.function.Predicate;
import javafx.scene.control.TextField;

public class PartingLog extends TextField implements PartingHandler {
    private volatile LinkedList<Entry> entries = new LinkedList<>();
    @Override
    public void addDeathCase(Mortal mortal) {
        entries.add(new DeathEntry(mortal));
        setText();
    }
    @Override
    public void addLeaveCase(Mortal mortal) {
        entries.add(new LeavingEntry(mortal));
        setText();
    }
    private synchronized void setText() {
        entries.removeIf(new EntryFilter());
        StringBuilder sb = new StringBuilder();
        entries.stream().map((entry) -> {
            sb.append(entry);
            sb.append("\n");
            return entry;
        });
        this.setText(sb.toString());
    }
    private class EntryFilter implements Predicate<Entry> {
        @Override
        public boolean test(Entry t) {
            return t.isExpired();
        }
    }
    private class DeathEntry extends Entry {
        public DeathEntry(Mortal mortal) {
            super(mortal, "died at age " + mortal.getAge());
        }
    }
    private class LeavingEntry extends Entry {
        public LeavingEntry(Mortal mortal) {
            super(mortal, "is no longer praying to you.");
        }
    }
    private abstract class Entry {
        private final String text;
        private final LocalTime started;

        public Entry(Mortal mortal, String action) {
            this.text = mortal.getName()
                    + ", a " + mortal.getAlignment() + " " + mortal.getClass().getSimpleName() + ", "
                    + action + ".";
            this.started = LocalTime.now();
        }
        public boolean isExpired() {
            return LocalTime.now().minusSeconds(75).isAfter(started);
        }
        @Override
        public String toString() {
            return text;
        }
    }
}
