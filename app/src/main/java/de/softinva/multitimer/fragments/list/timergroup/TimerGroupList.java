package de.softinva.multitimer.fragments.list.timergroup;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import de.softinva.multitimer.TimerGroupActivity;
import de.softinva.multitimer.fragments.list.AppList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import de.softinva.multitimer.R;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.utility.AppRecyclerAdapter;

/**
 * A fragment representing a list of Items.
 */
public class TimerGroupList extends AppList {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            TimerGroupListViewModel model = ViewModelProviders.of(this).get(TimerGroupListViewModel.class);
            model.getTimerGroupList().observe(this, (timeGroups) -> {
                recyclerView.setAdapter(new AppRecyclerAdapter(timeGroups, R.layout.timer_group_list_item, this));
            });
        } else {
            logger.error("view not instance of RecyclerView!");
        }

        return view;
    }


    @Override
    public void onAppListInteraction(Object obj) {
     if(obj instanceof TimerGroup){
         TimerGroup timerGroup = (TimerGroup) obj;
         Intent intent = new Intent(getActivity(),TimerGroupActivity.class);
         intent.putExtra(TimerGroupActivity.GROUP_ID, timerGroup.id);
         startActivity(intent);


     }
    }
}
