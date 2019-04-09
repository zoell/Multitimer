package de.softinva.multitimer.classes;

import java.util.Date;
import java.util.TreeMap;

import de.softinva.multitimer.model.Timer;

public class ActiveTimerMap {
    private TreeMap<Long, Integer> timerMap;

    public ActiveTimerMap() {
        timerMap = new TreeMap<>();
    }

    public Long addTimer(Integer timerId, Integer durationInSec ) {
        Long key = new Date().getTime() + durationInSec;
        Integer returnValue = timerMap.put(key, timerId);
        if (returnValue == null) {
            throw new Error("time pissibly not added to TreeMap");
        }
        return key;
    }

    public void removeTimer(Long key) {
        Integer returnValue = timerMap.remove(key);
        if (returnValue == null) {
            throw new Error("time pissibly not removed from TreeMap");
        }
    }

}
