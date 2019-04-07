package de.softinva.multitimer.repository;


import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.dummy.DummyNudelGericht;


public class TimerRepository {
    private MutableLiveData<ArrayList<TimerGroup>> timerGroup;
    protected static TimerRepository instance;

    private TimerRepository(){}

    public static TimerRepository getInstance(){
     if(instance == null){
         instance = new TimerRepository();
     }
     return instance;
    }
    public MutableLiveData<ArrayList<TimerGroup>> getTimerGroups() {

        if (this.timerGroup != null) {
            return this.timerGroup;
        }

        this.timerGroup = new MutableLiveData<>();
        ArrayList<TimerGroup> timerGroupList= new ArrayList<>();
        timerGroupList.add(new DummyNudelGericht().TIMER_GROUP);
        this.timerGroup.setValue(timerGroupList);

        return this.timerGroup;
    }

}
