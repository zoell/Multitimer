package de.softinva.multitimer.utility;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.TreeMap;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import de.softinva.multitimer.BR;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Object} and makes a call to the
 * specified.
 * TODO: Replace the implementation with code for your data type.
 * <p>
 * From https://medium.com/androiddevelopers/android-data-binding-recyclerview-db7c40d9f0e4
 * and from generated code after created new class
 */
public class AppRecyclerAdapter<T> extends RecyclerView.Adapter<AppViewHolder> {
    protected final TreeMap<Object, T> objectList;
    protected final int layoutId;
    protected LifecycleOwner owner;

    public AppRecyclerAdapter(TreeMap<Object, T> objectList, LifecycleOwner owner, int layoutId) {
        this.objectList = objectList;
        this.layoutId = layoutId;
        this.owner = owner;
    }

    public AppViewHolder onCreateViewHolder(ViewGroup parent,
                                            int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        binding.setLifecycleOwner(owner);
        return new AppViewHolder(binding);
    }

    public void onBindViewHolder(AppViewHolder holder,
                                 int position) {
        Object viewObject = getObjForPosition(position);
        holder.bind(viewObject);
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutId;
    }

    protected T getObjForPosition(int position) {
        return this.objectList.get(position);
    }

}

class AppViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public AppViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object viewObject) {
        binding.setVariable(BR.viewObject, viewObject);
        binding.executePendingBindings();
    }
}