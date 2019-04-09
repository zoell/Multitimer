package de.softinva.multitimer.fragments.list.running;

import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.classes.AppViewModel;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.repository.TimerRepository;

public class RunningTimerListViewModel extends AppViewModel {

    private MutableLiveData<TreeMap<Integer,Timer>> timerList;



    public MutableLiveData<TreeMap<Integer,Timer>>  getTimerList() {
        if (timerList == null) {
            timerList = new MutableLiveData<>();
            loadTimerList();
        }
        return timerList;
    }

    private void loadTimerList() {
        TreeMap map = TimerRepository.getInstance().getRunningTimer().getValue();
       this.timerList.setValue(map);
    }
}

