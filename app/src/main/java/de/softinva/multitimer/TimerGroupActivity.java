package de.softinva.multitimer;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


public class TimerGroupActivity extends AppCompatActivity{
    public static final String GROUP_ID = "de.softinva.multitimer.groupId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_group);

        Intent intent = getIntent();
        int groupId = intent.getIntExtra(GROUP_ID, -1);

        if(groupId != -1){
            TimerGroupViewModel model = ViewModelProviders.of(this).get(TimerGroupViewModel.class);
            model.getTimerGroupId().setValue(groupId);
            setTitle(model.getTimerGroup().getValue().title);
        }else{
            throw new Error("groupId is -1!");
        }

    }

}
