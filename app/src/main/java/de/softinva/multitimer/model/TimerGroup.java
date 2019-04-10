package de.softinva.multitimer.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TimerGroup {
    public final Integer id;
    public final String title;
    public final TreeMap<Integer, DetailedTimer> timerMap;
    public final boolean isZipped;

    public TimerGroup(Integer id, String title, boolean isZipped, TreeMap<Integer,DetailedTimer> timerMap) {
        this.id = id;
        this.title = title;
        this.timerMap = new TreeMap();
        this.isZipped = isZipped;
        for(Map.Entry<Integer,DetailedTimer> timerEntry: timerMap.entrySet()){
            this.timerMap.put(timerEntry.getValue().id, timerEntry.getValue());
        }
    }

    @Override
    public String toString() {
        return this.title;
    }
}
