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

    public static TimerGroup getTimerGroup(String timerGroupId, TreeMap<Integer, TimerGroup> timerGroupMap) {
        for (Map.Entry<Integer, TimerGroup> entry : timerGroupMap.entrySet()) {
            String groupId = entry.getValue().id;
            if (groupId.equals(timerGroupId)) {
                return entry.getValue();
            }
        }
        throw new Error("Timer Group with Id " + timerGroupId + " not found");
    }

    public static TreeMap<Long, RunningTimer> getTimerListForGroup(String timerGroupId, TreeMap<Long, RunningTimer> timerMap) {
        TreeMap<Long, RunningTimer> detailedTimerListForGroup = new TreeMap<>();
        for (Map.Entry<Long, RunningTimer> entry : timerMap.entrySet()) {
            RunningTimer runningTimer = entry.getValue();
            Timer timer = entry.getValue().getTimer();
            String groupId = timer.groupId;
            if (groupId.equals(timerGroupId)) {
                detailedTimerListForGroup.put(entry.getKey(), runningTimer);
            }
        }
        return detailedTimerListForGroup;
    }
}
