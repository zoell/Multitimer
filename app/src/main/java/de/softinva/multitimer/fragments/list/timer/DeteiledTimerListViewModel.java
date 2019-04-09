package de.softinva.multitimer.fragments.list.timer;

import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.classes.AppViewModel;
import de.softinva.multitimer.model.DetailedTimer;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.repository.TimerRepository;

public class DeteiledTimerListViewModel extends AppViewModel {

    private MutableLiveData<TreeMap<Integer, DetailedTimer>> timerList;



    public MutableLiveData<TreeMap<Integer,DetailedTimer>>  getTimerList() {
        if (timerList == null) {
            timerList = new MutableLiveData<>();
            loadTimerList();
        }
        return timerList;
    }

    private void loadTimerList() {
        TreeMap map = TimerRepository.getInstance().getTimerGroups().getValue().get(0).timerMap;
       this.timerList.setValue(map);
    }
}

