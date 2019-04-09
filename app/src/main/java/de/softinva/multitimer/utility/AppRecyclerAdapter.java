package de.softinva.multitimer.utility;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import de.softinva.multitimer.BR;
import de.softinva.multitimer.fragments.list.AppList;
import de.softinva.multitimer.classes.OnTimerListInteractionListener;
import de.softinva.multitimer.fragments.list.timergroup.TimerGroupList;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Object} and makes a call to the
 * specified {@link TimerGroupList.OnTimerListInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 * <p>
 * From https://medium.com/androiddevelopers/android-data-binding-recyclerview-db7c40d9f0e4
 * and from generated code after created new class
 */
public class AppRecyclerAdapter<T> extends RecyclerView.Adapter<AppViewHolder> {
    private final ArrayList<T> objectList;
    private final int layoutId;
    private final OnTimerListInteractionListener interactionListener;

    public AppRecyclerAdapter(ArrayList<T> objectList, int layoutId, AppList interactionListener) {
        this.objectList = objectList;
        this.layoutId = layoutId;
        this.interactionListener = interactionListener;
    }

    public AppViewHolder onCreateViewHolder(ViewGroup parent,
                                            int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        return new AppViewHolder(binding);
    }

    public void onBindViewHolder(AppViewHolder holder,
                                 int position) {
        Object obj = getObjForPosition(position);
        holder.bind(obj);
        holder.view.setOnClickListener(v -> {
            if (null != interactionListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                interactionListener.onAppListInteraction(obj);
            }
        });
    }
    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutId;
    }
    private T getObjForPosition(int position) {
       return  this.objectList.get(position);
    }

}

class AppViewHolder extends RecyclerView.ViewHolder {
    public final View view;
    private final ViewDataBinding binding;

    public AppViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        view = binding.getRoot();
        this.binding = binding;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.obj, obj);
        binding.executePendingBindings();
    }
}