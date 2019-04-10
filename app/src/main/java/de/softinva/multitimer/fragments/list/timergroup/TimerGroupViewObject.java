package de.softinva.multitimer.fragments.list.timergroup;

import android.content.Intent;
import android.view.View;

import de.softinva.multitimer.TimerGroupActivity;
import de.softinva.multitimer.model.TimerGroup;

public class TimerGroupViewObject {
    public TimerGroup timerGroup;
    TimerGroupViewObject(TimerGroup timerGroup){
        this.timerGroup = timerGroup;
    }
    public void onClickListItem(View view) {

    }

    public void onClickButton(View view) {
            Intent intent = new Intent(view.getContext(), TimerGroupActivity.class);
            intent.putExtra(TimerGroupActivity.GROUP_ID, timerGroup.id);
            view.getContext().startActivity(intent);

    }
}
