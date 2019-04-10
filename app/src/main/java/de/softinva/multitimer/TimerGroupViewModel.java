package de.softinva.multitimer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.softinva.multitimer.model.TABS;

public class TimerGroupViewModel extends ViewModel {
    private MutableLiveData<TABS> activeTab;
    private MutableLiveData<Integer> timerGroupId;

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
}
