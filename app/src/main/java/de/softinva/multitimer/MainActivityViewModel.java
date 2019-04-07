package de.softinva.multitimer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.softinva.multitimer.model.TABS;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<TABS> activeTab;

    public MutableLiveData<TABS> getActiveTab() {
        if (activeTab == null) {
            activeTab = new MutableLiveData<TABS>();
        }
        return activeTab;
    }

}
