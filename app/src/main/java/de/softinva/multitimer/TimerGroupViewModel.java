package de.softinva.multitimer;

import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.softinva.multitimer.classes.ActivityViewModel;
import de.softinva.multitimer.model.MAIN_ACTIVITY_TABS;
import de.softinva.multitimer.model.TABS;
import de.softinva.multitimer.model.TIMER_GROUP_ACTIVITY_TABS;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.repository.TimerRepository;
import de.softinva.multitimer.utility.UtilityMethods;

public class TimerGroupViewModel extends ActivityViewModel {
    private MutableLiveData<TABS> activeTab;
    private MutableLiveData<String> timerGroupId;
    private MutableLiveData<TimerGroup> timerGroup;

    @Override
    public MutableLiveData<TABS> getActiveTab() {
        if (activeTab == null) {
            activeTab = new MutableLiveData<>();
        }
        return activeTab;
    }


    public MutableLiveData<String> getTimerGroupId() {
        if (timerGroupId == null) {
            timerGroupId = new MutableLiveData<String>();
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
