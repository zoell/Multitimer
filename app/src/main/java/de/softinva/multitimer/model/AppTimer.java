package de.softinva.multitimer.model;

public class AppTimer {
    public final String id;
    public final String title;
    public final String description;
    public final Integer durationInSec;

    public AppTimer(String id, String title,String content, Integer durationInSec) {
        this.id = id;
        this.description = content;
        this.durationInSec = durationInSec;
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
