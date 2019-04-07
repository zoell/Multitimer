package de.softinva.multitimer.model;

import java.util.ArrayList;
import java.util.TreeMap;

public class TimerGroup {
    public final Integer id;
    public final String title;
    public final TreeMap<Integer, Timer> timerMap;

    public TimerGroup(Integer id, String title, ArrayList<DetailedTimer> timerArray) {
        this.id = id;
        this.title = title;
        this.timerMap = new TreeMap();
        for(Timer timer: timerArray){
            this.timerMap.put(timer.id, timer);
        }
    }

    @Override
    public String toString() {
        return this.title;
    }
}
