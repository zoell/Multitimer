package de.softinva.multitimer.repository.dummy;

import java.util.TreeMap;

import de.softinva.multitimer.classes.ActiveTimerMap;
import de.softinva.multitimer.model.Timer;

public class DummyRunningTimer {
    public static final TreeMap<Long, Timer> RUNNING_TIMER;
    static {
        ActiveTimerMap map = new ActiveTimerMap();
        map.addTimer(DummyNudelGericht.TIMER_Tomatensoße);
        map.addTimer(DummyTempTimer.TEMP_TIMER_1);
        map.addTimer(DummyTempTimer.TEMP_TIMER_2);
        map.addTimer(DummyTempTimer.TEMP_TIMER_3);
        RUNNING_TIMER = map.getTimerMap();

    }

}
