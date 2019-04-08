package de.softinva.multitimer.fragments.list.timergroup;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import de.softinva.multitimer.fragments.list.AppList;
import de.softinva.multitimer.model.Timer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;


import de.softinva.multitimer.R;
import de.softinva.multitimer.utility.AppRecyclerAdapter;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link AppList.OnTimerListInteractionListener}
 * interface.
 */
public class TimerGroupList extends AppList {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            TimerGroupListViewModel model = ViewModelProviders.of(this).get(TimerGroupListViewModel.class);
            model.getTimerList().observe(this, (timerList) -> {
                recyclerView.setAdapter(new AppRecyclerAdapter(new ArrayList<Timer>(timerList.values()), R.layout.app_list_item, mListener));
            });
        } else {
            logger.error("view not instance of RecyclerView!");
        }

        return view;
    }


}
