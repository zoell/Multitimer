package de.softinva.multitimer.repository;


import java.util.ArrayList;
import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.classes.ActiveTimerMap;
import de.softinva.multitimer.model.TempTimer;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.dummy.DummyNudelGericht;
import de.softinva.multitimer.repository.dummy.DummyPizza;
import de.softinva.multitimer.repository.dummy.DummyRunningTimer;
import de.softinva.multitimer.repository.dummy.DummyTempTimer;


public class TimerRepository {
    private MutableLiveData<TreeMap<Integer,TimerGroup>> timerGroup;
    private MutableLiveData<TreeMap<Integer,TempTimer>> tempTimer;
    private MutableLiveData<TreeMap<Long, Timer>> runningTimer;

    protected static TimerRepository instance;

    private TimerRepository(){}

    public static TimerRepository getInstance(){
     if(instance == null){
         instance = new TimerRepository();
     }
     return instance;
    }
    public MutableLiveData<TreeMap<Integer,TimerGroup>> getTimerGroups() {

        if (this.timerGroup != null) {
            return this.timerGroup;
        }

        this.timerGroup = new MutableLiveData<>();
        TreeMap<Integer,TimerGroup> timerGroupList= new TreeMap<>();
        timerGroupList.put(0,DummyNudelGericht.TIMER_GROUP);
        timerGroupList.put(1,DummyPizza.TIMER_GROUP);
        this.timerGroup.setValue(timerGroupList);

        return this.timerGroup;
    }
    public MutableLiveData<TreeMap<Integer,TempTimer>> getTempTimer() {

        if (this.tempTimer != null) {
            return this.tempTimer;
        }

        this.tempTimer = new MutableLiveData<>();
        this.tempTimer.setValue(DummyTempTimer.TEMP_TIMERS);

        return this.tempTimer;
    }

    public MutableLiveData<TreeMap<Long, Timer>> getRunningTimer() {

        if (this.runningTimer != null) {
            return this.runningTimer;
        }

        this.runningTimer = new MutableLiveData<>();
        this.runningTimer.setValue(DummyRunningTimer.RUNNING_TIMER);

        return this.runningTimer;
    }

}
