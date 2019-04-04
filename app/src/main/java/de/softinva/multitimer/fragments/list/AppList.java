package de.softinva.multitimer.fragments.list;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.softinva.multitimer.factory.AppListViewModelFactory;
import de.softinva.multitimer.model.AppTimer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import de.softinva.multitimer.R;
import de.softinva.multitimer.repository.TimerRepository;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnTimerListInteractionListener}
 * interface.
 */
public class AppList extends Fragment {
    private OnTimerListInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            Integer screenOrientation = context.getResources().getConfiguration().orientation;

            if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            }
            AppListViewModelFactory appListViewModelFactory = new AppListViewModelFactory(new TimerRepository());
            AppListViewModel model = ViewModelProviders.of(this, appListViewModelFactory).get(AppListViewModel.class);
            model.getTimerList().observe(this, (timerList) -> recyclerView.setAdapter(new AppListAdapter(timerList, mListener)));

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTimerListInteractionListener) {
            mListener = (OnTimerListInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTimerListInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnTimerListInteractionListener {
        // TODO: Update argument type and name
        void onAppListInteraction(AppTimer timer);
    }
}
