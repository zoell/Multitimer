package de.softinva.multitimer.classes;

import java.util.Date;
import java.util.TreeMap;

import de.softinva.multitimer.model.Timer;

public class ActiveTimerMap {
    private TreeMap<Long, Timer> timerMap;

    public ActiveTimerMap() {
        timerMap = new TreeMap<>();
    }

    public Long addTimer(Timer timer) {
        Long key = new Date().getTime() + timer.durationInSec;
        while (timerMap.get(key) != null) {
            key = key + 1;
        }
        timerMap.put(key, timer);
        return key;
    }

    public void removeTimer(Integer key) {
        Timer returnValue = timerMap.remove(key);
        if (returnValue == null) {
            throw new Error("timer possibly not removed from TreeMap");
        }
    }

    public TreeMap<Long, Timer> getTimerMap() {
        return timerMap;
    }

}
