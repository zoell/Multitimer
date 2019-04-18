package de.softinva.multitimer.fragments.list.timer;

import android.view.View;

import de.softinva.multitimer.CountDownService;
import de.softinva.multitimer.classes.AppViewObject;
import de.softinva.multitimer.model.RunningTimer;

public class DetailedTimerViewObject extends AppViewObject<RunningTimer> {

    public DetailedTimerViewObject(RunningTimer runningTimer) {
        super(runningTimer);
    }

    public void onClickButton(View view) {
        if(obj.isRunning()){
            CountDownService.cancelTimer(obj.getTimer().toTimer(), view.getContext());

        }else{
            CountDownService.startNewTimer(obj.getTimer().toTimer(), view.getContext());
        }

    }
}
