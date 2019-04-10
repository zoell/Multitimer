package de.softinva.multitimer.fragments.list.timergroup;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import de.softinva.multitimer.TimerGroupActivity;
import de.softinva.multitimer.model.TimerGroup;

public class TimerGroupViewObject {
    public TimerGroup timerGroup;
    public int buttonSrcCompat;

    TimerGroupViewObject(TimerGroup timerGroup){
        this.timerGroup = timerGroup;
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int buttonSrcCompat) {
        view.setImageResource(buttonSrcCompat);
    }


    public void setButtonSrcCompat(int buttonSrcCompat) {
        this.buttonSrcCompat = buttonSrcCompat;
    }

    public void onClickListItem(View view) {

    }

    public void onClickButton(View view) {
            Intent intent = new Intent(view.getContext(), TimerGroupActivity.class);
            intent.putExtra(TimerGroupActivity.GROUP_ID, timerGroup.id);
            view.getContext().startActivity(intent);

    }
}
