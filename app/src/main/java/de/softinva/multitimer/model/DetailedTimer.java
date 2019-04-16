package de.softinva.multitimer.model;

import de.softinva.multitimer.fragments.list.timer.DetailedTimerViewObject;

public class DetailedTimer extends Timer {
    public final String description;

    public DetailedTimer(String id, String groupId, String title, Integer durationInSec, String description, String imageName) {
        super(id, groupId, title, durationInSec, imageName);
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public DetailedTimerViewObject createViewObject() {
        return new DetailedTimerViewObject(this);
    }
}
