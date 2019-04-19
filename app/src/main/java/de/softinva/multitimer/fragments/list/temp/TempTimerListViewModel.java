package de.softinva.multitimer.fragments.list.temp;

import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import de.softinva.multitimer.classes.FragmentViewModel;
import de.softinva.multitimer.model.RunningTimer;
import de.softinva.multitimer.repository.TimerRepository;
import de.softinva.multitimer.utility.UtilityMethods;

public class TempTimerListViewModel extends FragmentViewModel {

    private MutableLiveData<TreeMap<Integer,RunningTimer>> timerList;



    public MutableLiveData<TreeMap<Integer,RunningTimer>>  getTimerList() {
        if (timerList == null) {
            timerList = new MutableLiveData<>();
            createTimerList();
        }
        return timerList;
    }

    private void createTimerList() {
        timerList = (MutableLiveData<TreeMap<Integer, RunningTimer>>) Transformations.switchMap(
                TimerRepository.getInstance().getTempTimer(), timerMap ->
            UtilityMethods.updateTimerList(timerMap));
    }
}

