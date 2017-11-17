package de.idrinth.gods_and_heroes.services;

import java.util.Timer;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimerSchedulerTest {
    @Test
    public void testType() {
        assertTrue(Timer.class.isInstance(new TimerScheduler()));
        assertTrue(Scheduler.class.isInstance(new TimerScheduler()));
    }
    
}
