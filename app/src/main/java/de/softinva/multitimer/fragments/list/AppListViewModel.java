package de.softinva.multitimer.fragments.list;

import java.util.List;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.softinva.multitimer.model.AppTimer;
import de.softinva.multitimer.repository.TimerRepository;

public class AppListViewModel extends ViewModel {

    private MutableLiveData<List<AppTimer>> timerList;
    TimerRepository timerRepo;


    public AppListViewModel(TimerRepository timerRepo) {
        this.timerRepo = timerRepo;
    }

    public MutableLiveData<List<AppTimer>> getTimerList() {
        if (timerList == null) {
            timerList = new MutableLiveData<List<AppTimer>>();
            loadTimerList();
        }
        return timerList;
    }

    private void loadTimerList() {
        timerList = this.timerRepo.getTimerList();
    }
}
