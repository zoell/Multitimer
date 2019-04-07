package de.softinva.multitimer.model;

public class DetailedTimer extends Timer {
    public final String description;
    public final String imageName;

    public DetailedTimer(Integer id, String title, Integer durationInSec, String description, String imageName) {
        super(id, title, durationInSec);
        this.description = description;
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
