package de.idrinth.gods_and_heroes.services;

import java.util.Timer;

public class TimerScheduler extends Timer implements Scheduler {
    public TimerScheduler() {
        super("game-timer", true);
    }
}
