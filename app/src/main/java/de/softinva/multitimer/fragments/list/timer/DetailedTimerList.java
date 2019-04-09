package de.softinva.multitimer.fragments.list.timer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import de.softinva.multitimer.R;
import de.softinva.multitimer.fragments.list.AppList;
import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.utility.AppRecyclerAdapter;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class DetailedTimerList extends AppList {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            DeteiledTimerListViewModel model = ViewModelProviders.of(this).get(DeteiledTimerListViewModel.class);
            model.getTimerList().observe(this, (timerList) -> {
                recyclerView.setAdapter(new AppRecyclerAdapter(timerList, R.layout.detailed_timer_list_item, this));
            });
        } else {
            logger.error("view not instance of RecyclerView!");
        }

        return view;
    }

    @Override
    public void onAppListInteraction(Object obj) {

    }
}
