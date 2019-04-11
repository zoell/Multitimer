package de.softinva.multitimer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import de.softinva.multitimer.classes.ActivityViewModel;
import de.softinva.multitimer.model.MAIN_ACTIVITY_TABS;
import de.softinva.multitimer.model.TABS;

public class MainActivityViewModel extends ActivityViewModel {
    private MutableLiveData<TABS> activeTab;

    public MutableLiveData<TABS> getActiveTab() {
        if (activeTab == null) {
            activeTab = new MutableLiveData<>();
        }
        return activeTab;
    }

}
