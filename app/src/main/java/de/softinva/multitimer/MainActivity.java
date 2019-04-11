package de.softinva.multitimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.logging.LogManager;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import de.softinva.multitimer.classes.AppActivity;
import de.softinva.multitimer.fragments.list.running.RunningTimerList;
import de.softinva.multitimer.fragments.list.temp.TempTimerList;
import de.softinva.multitimer.fragments.list.temp.TempTimerListViewModel;
import de.softinva.multitimer.fragments.list.timergroup.TimerGroupList;
import de.softinva.multitimer.model.MAIN_ACTIVITY_TABS;
import de.softinva.multitimer.model.TABS;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.fragments.list.AppList;
import de.softinva.multitimer.model.TimerGroup;


public class MainActivity extends AppActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewIfOrientationLandscape();
    }
    @Override
    protected void setActiveTab(){
        if(model.getActiveTab().getValue() == null){
            model.getActiveTab().setValue(MAIN_ACTIVITY_TABS.List);
        }
    }
    @Override
    protected Fragment selectFragment(){
        Fragment fragment;

        MAIN_ACTIVITY_TABS tab = (MAIN_ACTIVITY_TABS) model.getActiveTab().getValue();
        switch (tab) {
            case List:
                fragment = new TimerGroupList();
                break;
            case Temp:
                fragment = new TempTimerList();
                break;
            case Running:
                fragment = new RunningTimerList();
                break;
            default:
                throw new Error("active tab is not supported!");
        }
        return fragment;
    }

    @Override
    protected void setModel() {
        model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
    }
}
