package de.softinva.multitimer.model;

import java.util.TreeMap;

import de.softinva.multitimer.classes.AppPOJO;
import de.softinva.multitimer.fragments.list.timergroup.TimerGroupViewObject;

public class TimerGroup implements AppPOJO {
    public final String id;
    public final String title;
    public final TreeMap<Integer, DetailedTimer> timerMap;
    public final boolean isZipped;

    public TimerGroup(String id, String title, boolean isZipped, TreeMap<Integer,DetailedTimer> timerMap) {
        this.id = id;
        this.title = title;
        this.timerMap = timerMap;
        this.isZipped = isZipped;

    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public TimerGroupViewObject createViewObject() {
        return new TimerGroupViewObject(this);
    }
}
