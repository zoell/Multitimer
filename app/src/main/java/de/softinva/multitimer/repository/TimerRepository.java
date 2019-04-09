package de.softinva.multitimer.repository;


import java.util.ArrayList;
import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.model.TempTimer;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.dummy.DummyNudelGericht;
import de.softinva.multitimer.repository.dummy.DummyPizza;
import de.softinva.multitimer.repository.dummy.DummyTempTimer;


public class TimerRepository {
    private MutableLiveData<TreeMap<Integer,TimerGroup>> timerGroup;
    private MutableLiveData<ArrayList<TempTimer>> tempTimer;

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
        timerGroupList.put(0,new DummyNudelGericht().TIMER_GROUP);
        timerGroupList.put(1,new DummyPizza().TIMER_GROUP);
        this.timerGroup.setValue(timerGroupList);

        return this.timerGroup;
    }
    public MutableLiveData<ArrayList<TempTimer>> getTempTimer() {

        if (this.tempTimer != null) {
            return this.tempTimer;
        }

        this.tempTimer = new MutableLiveData<>();
        this.tempTimer.setValue(new DummyTempTimer().TEMP_TIMERS);

        return this.tempTimer;
    }

}
