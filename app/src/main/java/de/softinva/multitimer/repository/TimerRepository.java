package de.softinva.multitimer.repository;


import java.util.List;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.model.AppTimer;
import de.softinva.multitimer.repository.dummy.DummyTimerList;


public class TimerRepository {
    private MutableLiveData<List<AppTimer>> timerList;

    public MutableLiveData<List<AppTimer>> getTimerList() {

        if (this.timerList != null) {
            return this.timerList;
        }

        this.timerList = new MutableLiveData<>();
        this.timerList.setValue(DummyTimerList.ITEMS);

        return this.timerList;
    }

}
