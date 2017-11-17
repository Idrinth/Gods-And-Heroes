package de.idrinth.gods_and_heroes.services;

import java.util.TimerTask;

public interface Scheduler {
    public int purge();
    public void cancel();
    public void scheduleAtFixedRate(TimerTask task, long delay, long period);
}
