package de.softinva.multitimer.fragments.list;

import androidx.recyclerview.widget.RecyclerView;
import de.softinva.multitimer.R;
import de.softinva.multitimer.model.Timer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * {@link RecyclerView.Adapter} that can display a {@link Timer} and makes a call to the
 * specified {@link AppList.OnTimerListInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private final ArrayList<Timer> timerList;
    private final AppList.OnTimerListInteractionListener timerListListener;

    public AppListAdapter(ArrayList<Timer> timerList, AppList.OnTimerListInteractionListener timerListListener) {
        this.timerList = timerList;
        this.timerListListener = timerListListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.timer = timerList.get(position);
        holder.mContentView.setText(timerList.get(position).title);

        holder.mView.setOnClickListener(v -> {
            if (null != timerListListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                timerListListener.onAppListInteraction(holder.timer);
            }
        });
    }

    @Override
    public int getItemCount() {
        return timerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mContentView;
        public Timer timer;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.image);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
