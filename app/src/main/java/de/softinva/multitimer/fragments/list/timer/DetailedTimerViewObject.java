package de.softinva.multitimer.fragments.list.timer;

import android.view.View;

import de.softinva.multitimer.CountDownService;
import de.softinva.multitimer.model.DetailedTimer;

public class DetailedTimerViewObject {
    DetailedTimer timer;

    public DetailedTimerViewObject(DetailedTimer detailedTimer) {
        timer = detailedTimer;
    }
    public DetailedTimer getTimer() {
        return timer;
    }

    public void setTimer(DetailedTimer timer) {
        this.timer = timer;
    }
    public void onClickButton(View view) {
        CountDownService.startNewTimer(timer.toTimer(), view.getContext());
    }
}
