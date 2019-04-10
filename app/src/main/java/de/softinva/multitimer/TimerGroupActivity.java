package de.softinva.multitimer;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


public class TimerGroupActivity extends AppCompatActivity{
    public static final String GROUP_ID = "de.softinva.multitimer.groupId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_group);
        Integer groupId = savedInstanceState.getInt(GROUP_ID);
        TimerGroupViewModel model = ViewModelProviders.of(this).get(TimerGroupViewModel.class);
        model.getTimerGroupId().setValue(groupId);
    }

}
