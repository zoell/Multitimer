package de.softinva.multitimer.fragments.list.timergroup;
import java.util.TreeMap;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import de.softinva.multitimer.classes.AppViewModel;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.TimerRepository;

public class TimerGroupListViewModel extends AppViewModel {
    private MutableLiveData<TreeMap<Integer,TimerGroup>> timerList;

    public MutableLiveData<TreeMap<Integer, TimerGroup>> getTimerGroupList() {
        if (timerList == null) {
            timerList = TimerRepository.getInstance().getTimerGroups();
        }
        return timerList;
    }

}

