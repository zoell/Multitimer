package de.softinva.multitimer.fragments.list.timer;

import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import de.softinva.multitimer.classes.AppViewModel;
import de.softinva.multitimer.model.DetailedTimer;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.TimerRepository;

import static de.softinva.multitimer.utility.UtilityMethods.getTimerGroup;

public class DetailedTimerListViewModel extends AppViewModel {

    private MutableLiveData<TreeMap<Integer, DetailedTimer>> timerList;

    public MutableLiveData<TreeMap<Integer,DetailedTimer>>  getTimerList(String timerGroupId) {
        if (timerList == null) {
            loadTimerList(timerGroupId);
        }
        return timerList;
    }

    private void loadTimerList(String timerGroupId) {
        MutableLiveData<TreeMap<Integer, TimerGroup>> timerGroupMap =  TimerRepository.getInstance().getTimerGroups();
        timerList = (MutableLiveData<TreeMap<Integer, DetailedTimer>>)Transformations.map(timerGroupMap , timerMap->{return getTimerGroup(timerGroupId, timerMap).timerMap;});
    }
}

