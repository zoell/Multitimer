package de.softinva.multitimer.fragments.list.temp;

import java.util.ArrayList;
import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import de.softinva.multitimer.classes.AppViewModel;
import de.softinva.multitimer.model.TempTimer;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.repository.TimerRepository;

public class TempTimerListViewModel extends AppViewModel {

    private MutableLiveData<ArrayList<TempTimer>> timerList;



    public MutableLiveData<ArrayList<TempTimer>>  getTimerList() {
        if (timerList == null) {
            timerList = new MutableLiveData<>();
            loadTimerList();
        }
        return timerList;
    }

    private void loadTimerList() {
        ArrayList<TempTimer> tempTimerList = TimerRepository.getInstance().getTempTimer().getValue();
       this.timerList.setValue(tempTimerList);
    }
}

