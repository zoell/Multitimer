package de.softinva.multitimer.utility;

import java.util.Map;
import java.util.TreeMap;

import de.softinva.multitimer.model.RunningTimer;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.model.TimerGroup;

public class UtilityMethods {
    public static AppLogger createLogger(Object classObject) {
        AppLogger logger = new AppLogger(classObject);
        return logger;
    }


}
