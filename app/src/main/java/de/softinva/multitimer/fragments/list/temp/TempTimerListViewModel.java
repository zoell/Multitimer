package de.softinva.multitimer.fragments.list.temp;

import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.classes.FragmentViewModel;
import de.softinva.multitimer.model.RunningTimer;
import de.softinva.multitimer.repository.TimerRepository;

public class TempTimerListViewModel extends FragmentViewModel {

    private MutableLiveData<TreeMap<Integer,RunningTimer>> timerList;



    public MutableLiveData<TreeMap<Integer,RunningTimer>>  getTimerList() {
        if (timerList == null) {
            timerList = new MutableLiveData<>();
            loadTimerList();
        }
        return timerList;
    }

    private void loadTimerList() {
        TreeMap<Integer, RunningTimer> tempTimerList = TimerRepository.getInstance().getTempTimer().getValue();
       this.timerList.setValue(tempTimerList);
    }
}

