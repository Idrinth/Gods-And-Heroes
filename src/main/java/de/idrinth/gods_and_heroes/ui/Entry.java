package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Mortal;
import java.time.LocalTime;

public abstract class Entry {
    private final String name;
    private final Alignment alignment;
    private final String event;
    private final LocalTime started;

    public Entry(Mortal mortal, String event) {
        name = mortal.getName();
        alignment = mortal.getAlignment();
        this.event = event;
        started = LocalTime.now();
    }
    public boolean isExpired() {
        return (started.plusSeconds(5)).isBefore(LocalTime.now());
    }
    public String getName() {
        return name;
    }
    public String getAlignment() {
        return alignment.toString();
    }
    public String getEvent() {
        return event;
    }
}