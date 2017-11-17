/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.idrinth.gods_and_heroes.services;

import java.util.TimerTask;

public class TimelessScheduler implements Scheduler {

    @Override
    public int purge() {
        return 0;
    }

    @Override
    public void cancel() {
        // not intended to do anything
    }

    @Override
    public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        task.cancel();
    }
}
