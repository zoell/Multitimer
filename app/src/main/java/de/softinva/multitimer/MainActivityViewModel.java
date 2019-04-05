package de.softinva.multitimer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.softinva.multitimer.model.Tabs;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<Tabs> activeTab;

    public MutableLiveData<Tabs> getActiveTab() {
        if (activeTab == null) {
            activeTab = new MutableLiveData<Tabs>();
        }
        return activeTab;
    }

}
