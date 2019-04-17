package de.softinva.multitimer.repository;
import android.content.Context;


import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.CountDownService;
import de.softinva.multitimer.model.RunningTimer;

import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.dummy.DummyNudelGericht;
import de.softinva.multitimer.repository.dummy.DummyPizza;
import de.softinva.multitimer.repository.dummy.DummyRunningTimer;
import de.softinva.multitimer.repository.dummy.DummyTempTimer;


public class TimerRepository {
    protected MutableLiveData<TreeMap<Integer, TimerGroup>> timerGroupMap;
    protected MutableLiveData<TreeMap<Integer, RunningTimer>> tempTimerMap;
    protected MutableLiveData<TreeMap<Long, RunningTimer>> runningTimerMap;

    protected static TimerRepository instance;

    private TimerRepository() {
    }

    public static TimerRepository getInstance() {
        if (instance == null) {
            instance = new TimerRepository();
        }
        return instance;
    }

    public MutableLiveData<TreeMap<Integer, TimerGroup>> getTimerGroups() {

        if (this.timerGroupMap != null) {
            return timerGroupMap;
        }

        timerGroupMap = new MutableLiveData<>();
        TreeMap<Integer, TimerGroup> timerGroupList = new TreeMap<>();
        timerGroupList.put(0, DummyNudelGericht.TIMER_GROUP);
        timerGroupList.put(1, DummyPizza.TIMER_GROUP);
        timerGroupMap.setValue(timerGroupList);

        return timerGroupMap;
    }

    public MutableLiveData<TreeMap<Integer, RunningTimer>> getTempTimer() {

        if (this.tempTimerMap != null) {
            return this.tempTimerMap;
        }

        this.tempTimerMap = new MutableLiveData<>();
        this.tempTimerMap.setValue(DummyTempTimer.TEMP_TIMERS);

        return this.tempTimerMap;
    }

    public MutableLiveData<TreeMap<Long, RunningTimer>> getDummyRunningTimer() {
        if (runningTimerMap == null) {
            runningTimerMap = new MutableLiveData<>();
            runningTimerMap.setValue(DummyRunningTimer.RUNNING_TIMER);
        }

        return runningTimerMap;
    }

    public MutableLiveData<TreeMap<Long, RunningTimer>> getRunningTimerMap() {
        if (runningTimerMap == null) {
            runningTimerMap = CountDownService.runningTimerLiveDataMap;
        }
        return runningTimerMap;
    }


}