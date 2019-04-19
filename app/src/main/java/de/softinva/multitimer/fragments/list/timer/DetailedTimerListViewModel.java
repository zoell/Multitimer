package de.softinva.multitimer.fragments.list.timer;

import java.util.Map;
import java.util.TreeMap;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import de.softinva.multitimer.classes.FragmentViewModel;
import de.softinva.multitimer.model.DetailedTimer;
import de.softinva.multitimer.model.RunningTimer;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.repository.TimerRepository;


public class DetailedTimerListViewModel extends FragmentViewModel {

    private MutableLiveData<TreeMap<Integer, RunningTimer>> timerList;

    public MutableLiveData<TreeMap<Integer, RunningTimer>> getTimerList(String timerGroupId) {
        if (timerList == null) {
            createTimerList(timerGroupId);
        }
        return timerList;
    }

    private void createTimerList(String timerGroupId) {
        MutableLiveData<TreeMap<String, RunningTimer>> runningTimerMap = TimerRepository.getInstance().getRunningTimerByIDMap();
        timerList = (MutableLiveData<TreeMap<Integer, RunningTimer>>) Transformations.switchMap(runningTimerMap, rTimerMap -> {

            return Transformations.map(TimerRepository.getInstance().getTimerGroup(timerGroupId), timerGroup -> {
                TreeMap<Integer, RunningTimer> timerMap = timerGroup.timerMap;
                for (Map.Entry<String, RunningTimer> runningTimer : rTimerMap.entrySet()) {
                    updateRunningTimer(runningTimer.getValue(), timerMap);
                }
                return timerMap;
            });

        });
    }

    protected void updateRunningTimer(RunningTimer runningTimer, TreeMap<Integer, RunningTimer> tList) {
        for (Map.Entry<Integer, RunningTimer> timerEntry : tList.entrySet()) {
            RunningTimer runningTimerInList = timerEntry.getValue();
            Timer timerInstance = runningTimerInList.getTimer();
            if (timerInstance.id.equals(runningTimer.getTimer().id)) {
                if (timerInstance instanceof DetailedTimer) {
                    runningTimer.setTimer(runningTimerInList.getTimer());
                    tList.put(timerEntry.getKey(), runningTimer);
                    return;
                } else {
                    throw new Error("timer should be instance of DetailedTimer!");
                }

            }
        }

    }
}

