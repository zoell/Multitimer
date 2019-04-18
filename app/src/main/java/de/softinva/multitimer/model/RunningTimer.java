package de.softinva.multitimer.model;

import java.util.Date;

import androidx.lifecycle.MutableLiveData;


public class RunningTimer {
    protected Timer timer;
    protected Long finishTimeInSec;
    protected MutableLiveData<Long> countDownInSec;
    protected boolean isRunning = false;

    public RunningTimer(Timer timer) {
        this.timer = timer;
        countDownInSec = new MutableLiveData<>();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public MutableLiveData<Long> getCountDownInSec() {
        return countDownInSec;
    }


    public Long getFinishTimeInSec() {
        if (finishTimeInSec == null) {
            throw new Error("Timer not yet started!");
        }
        return finishTimeInSec;
    }

    public void setToStart() {
        if (finishTimeInSec != null) {
            throw new Error("Finish time already set!");
        }
        finishTimeInSec = new Date().getTime() + (timer.durationInSec * 1000);
        isRunning = true;
    }

    public void setToStop() {
        finishTimeInSec = null;
        isRunning = false;
    }

}
