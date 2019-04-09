package de.softinva.multitimer.repository.dummy;

import java.util.ArrayList;

import de.softinva.multitimer.model.DetailedTimer;
import de.softinva.multitimer.model.TempTimer;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.utility.AppLogger;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyTempTimer {
    private  final ArrayList<DetailedTimer> TIMER_LIST = new ArrayList<>();
    private AppLogger logger;
    public  final ArrayList<TempTimer> TEMP_TIMERS;


    public DummyTempTimer() {
        TEMP_TIMERS = new ArrayList<TempTimer>();
        TEMP_TIMERS.add(new TempTimer(0, "Temp Timer 1", 600));
        TEMP_TIMERS.add(new TempTimer(0, "Temp Timer 2", 600));
        TEMP_TIMERS.add(new TempTimer(0, "Temp Timer 3", 600));
    }


}
