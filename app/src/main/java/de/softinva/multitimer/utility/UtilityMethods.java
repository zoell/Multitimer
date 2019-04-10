package de.softinva.multitimer.utility;

import java.util.Map;
import java.util.TreeMap;

import de.softinva.multitimer.model.TimerGroup;

public class UtilityMethods {
    public static AppLogger createLogger(Object classObject) {
        AppLogger logger = new AppLogger(classObject);
        return logger;
    }

    public static TimerGroup getTimerGroup(Integer timerGroupId, TreeMap<Integer, TimerGroup> timerGroupMap) {
        for (Map.Entry<Integer, TimerGroup> entry : timerGroupMap.entrySet()) {
            Integer groupId = entry.getValue().id;
            if (groupId == timerGroupId) {
                return entry.getValue();
            }
        }
        throw new Error("Timer Group with Id" + timerGroupId + " not found");
    }
}
