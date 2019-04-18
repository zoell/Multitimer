package de.softinva.multitimer.model;

public class DetailedTimer extends Timer {
    public final String description;

    public DetailedTimer(String id, String groupId, String title, Integer durationInSec, String imageName, String description) {
        super(id, groupId, title, durationInSec, imageName);
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
