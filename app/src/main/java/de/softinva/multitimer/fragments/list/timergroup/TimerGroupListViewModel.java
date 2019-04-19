package de.softinva.multitimer.fragments.list.timergroup;
import java.util.TreeMap;


import androidx.lifecycle.MutableLiveData;

import de.softinva.multitimer.classes.FragmentViewModel;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.TimerRepository;

public class TimerGroupListViewModel extends FragmentViewModel {
    private MutableLiveData<TreeMap<Integer,TimerGroup>> timerList;

    public MutableLiveData<TreeMap<Integer, TimerGroup>> getTimerGroupList() {
        if (timerList == null) {
            timerList = TimerRepository.getInstance().getTimerGroups();
        }
        return timerList;
    }

}

