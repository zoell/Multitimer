package de.softinva.multitimer.model;

public class DetailedTimer extends Timer {
    public final Integer groupId;
    public final String description;
    public final String imageName;

    public DetailedTimer(Integer id, Integer groupId, String title, Integer durationInSec, String description, String imageName) {
        super(id, title, durationInSec);
        this.groupId = groupId;
        this.description = description;
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
