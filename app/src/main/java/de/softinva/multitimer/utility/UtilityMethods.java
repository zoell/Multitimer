package de.softinva.multitimer.utility;

import java.util.Map;
import java.util.TreeMap;

import de.softinva.multitimer.model.DetailedTimer;
import de.softinva.multitimer.model.Timer;
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

    public static TreeMap<Object, DetailedTimer> getTimerListForGroup(Integer timerGroupId, TreeMap<Object, Timer> timerMap) {
        TreeMap<Object, DetailedTimer> detailedTimerListForGroup = new TreeMap<>();
        for (Map.Entry<Object, Timer> entry : timerMap.entrySet()) {
            Timer timer = entry.getValue();
            if (timer instanceof DetailedTimer) {
                DetailedTimer detailedTimer = (DetailedTimer) timer;
                Integer groupId = detailedTimer.groupId;
                if (groupId == timerGroupId) {
                    detailedTimerListForGroup.put(entry.getKey(), detailedTimer);
                }
            }

        }
        return detailedTimerListForGroup;
    }
}
