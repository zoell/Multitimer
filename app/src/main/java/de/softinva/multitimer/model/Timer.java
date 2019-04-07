package de.softinva.multitimer.model;

public class Timer {
    public final Integer id;
    public final String title;
    public final Integer durationInSec;

    public Timer(Integer id, String title, Integer durationInSec) {
        this.id = id;
        this.durationInSec = durationInSec;
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
