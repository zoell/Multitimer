package de.softinva.multitimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.softinva.multitimer.model.AppTimer;
import de.softinva.multitimer.fragments.list.AppList;


public class MainActivity extends AppCompatActivity implements AppList.OnTimerListInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAppListInteraction(AppTimer timer) {
        System.out.println(timer.title);
    }

}
