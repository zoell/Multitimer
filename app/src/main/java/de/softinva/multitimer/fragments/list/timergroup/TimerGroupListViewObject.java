package de.softinva.multitimer.fragments.list.timergroup;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;

import de.softinva.multitimer.R;
import de.softinva.multitimer.activities.TimerGroupActivity;
import de.softinva.multitimer.activities.timergroup.info.TimerGroupInfoActivity;
import de.softinva.multitimer.classes.AppViewObject;
import de.softinva.multitimer.model.TimerGroup;

public class TimerGroupListViewObject extends AppViewObject<TimerGroup> {

    public int buttonSrcCompat;

    public TimerGroupListViewObject(TimerGroup timerGroup) {
        super(timerGroup);
        if (timerGroup.isZipped()) {
            buttonSrcCompat = R.drawable.ic_av_timer_black_24dp;
        } else {
            buttonSrcCompat = R.drawable.ic_chevron_right_black_24dp;
        }
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int buttonSrcCompat) {
        view.setImageResource(buttonSrcCompat);
    }

    public void onClickButton(View view) {
            TimerGroupActivity.startNewActivity(obj.getId(), view.getContext());
    }

    public void onClickTimerGroup(View view) {
        TimerGroupInfoActivity.startNewActivity(obj.getId(), view.getContext());
    }
}
