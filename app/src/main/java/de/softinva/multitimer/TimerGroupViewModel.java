package de.softinva.multitimer;

import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.softinva.multitimer.model.DetailedTimer;
import de.softinva.multitimer.model.TABS;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.TimerRepository;
import de.softinva.multitimer.utility.UtilityMethods;

import static de.softinva.multitimer.utility.UtilityMethods.getTimerGroup;

public class TimerGroupViewModel extends ViewModel {
    private MutableLiveData<TABS> activeTab;
    private MutableLiveData<Integer> timerGroupId;
    private MutableLiveData<TimerGroup> timerGroup;

    public MutableLiveData<TABS> getActiveTab() {
        if (activeTab == null) {
            activeTab = new MutableLiveData<TABS>();
        }
        return activeTab;
    }


    public MutableLiveData<Integer> getTimerGroupId() {
        if (timerGroupId == null) {
            timerGroupId = new MutableLiveData<Integer>();
        }
        return timerGroupId;
    }
    public MutableLiveData<TimerGroup> getTimerGroup() {
        if (timerGroup == null) {
            timerGroup = new MutableLiveData<TimerGroup>();
            loadTimerList();
        }
        return timerGroup;
    }

    private void loadTimerList() {
        TreeMap<Integer, TimerGroup> timerGroupMap =  TimerRepository.getInstance().getTimerGroups().getValue();
        TimerGroup timerGroup = UtilityMethods.getTimerGroup(this.timerGroupId.getValue(), timerGroupMap);
        this.timerGroup.setValue(timerGroup);
    }
}
