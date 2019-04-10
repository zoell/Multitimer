package de.softinva.multitimer.fragments.list.timer;

import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.classes.AppViewModel;
import de.softinva.multitimer.model.DetailedTimer;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.TimerRepository;

import static de.softinva.multitimer.utility.UtilityMethods.getTimerGroup;

public class DetailedTimerListViewModel extends AppViewModel {

    private MutableLiveData<TreeMap<Integer, DetailedTimer>> timerList;



    public MutableLiveData<TreeMap<Integer,DetailedTimer>>  getTimerList(Integer timerGroupId) {
        if (timerList == null) {
            timerList = new MutableLiveData<>();
            loadTimerList(timerGroupId);
        }
        return timerList;
    }

    private void loadTimerList(Integer timerGroupId) {
        TreeMap<Integer, TimerGroup> timerGroupMap =  TimerRepository.getInstance().getTimerGroups().getValue();
        TimerGroup map = getTimerGroup(timerGroupId, timerGroupMap);
       this.timerList.setValue(map.timerMap);
    }
}

