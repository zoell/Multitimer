package de.softinva.multitimer.fragments.list.running;

import java.util.Map;
import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import de.softinva.multitimer.classes.AppViewModel;
import de.softinva.multitimer.model.RunningTimer;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.repository.TimerRepository;
import de.softinva.multitimer.utility.UtilityMethods;

public class RunningTimerListViewModel extends AppViewModel {

    private MutableLiveData<TreeMap<Long, RunningTimer>> timerList;
    private MutableLiveData<TreeMap<Long, RunningTimer>> timerListForGroup;


    public MutableLiveData<TreeMap<Long, RunningTimer>> getTimerList() {
        if (timerList == null) {
            timerList = TimerRepository.getInstance().getRunningTimerByFinishTimeMap();
        }
        return timerList;
    }

    public MutableLiveData<TreeMap<Long, RunningTimer>> getTimerListForGroup(String groupId) {
        if (timerListForGroup == null) {
            loadTimerListForGroup(groupId);
        }
        return timerListForGroup;
    }

    private void loadTimerListForGroup(String groupId) {
        MutableLiveData<TreeMap<Long, RunningTimer>> map = TimerRepository.getInstance().getRunningTimerByFinishTimeMap();
        timerListForGroup = (MutableLiveData<TreeMap<Long, RunningTimer>>) Transformations.map(map, runningTimerMap -> {
            return getTimerListForGroup(groupId, runningTimerMap);
        });
    }
    private TreeMap<Long, RunningTimer> getTimerListForGroup(String timerGroupId, TreeMap<Long, RunningTimer> timerMap) {
        TreeMap<Long, RunningTimer> detailedTimerListForGroup = new TreeMap<>();
        for (Map.Entry<Long, RunningTimer> entry : timerMap.entrySet()) {
            RunningTimer runningTimer = entry.getValue();
            Timer timer = entry.getValue().getTimer();
            String groupId = timer.groupId;
            if (groupId.equals(timerGroupId)) {
                detailedTimerListForGroup.put(entry.getKey(), runningTimer);
            }
        }
        return detailedTimerListForGroup;
    }
}

