package de.softinva.multitimer.fragments.tabs.timergroupactivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import de.softinva.multitimer.fragments.list.running.RunningTimerList;
import de.softinva.multitimer.fragments.list.temp.TempTimerList;
import de.softinva.multitimer.fragments.list.timer.DetailedTimerList;
import de.softinva.multitimer.fragments.list.timergroup.TimerGroupList;


public class TimerGroupTabsAdapter extends FragmentPagerAdapter{
    String[] tabTitel;
    public TimerGroupTabsAdapter(FragmentManager fm, String[] tabTitles) {
        super(fm);
        this.tabTitel = tabTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DetailedTimerList();
            case 2:
                return new RunningTimerList();
            default:
            throw new Error("position not supported!"+position);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return  tabTitel[0];
            case 1:
                return tabTitel[1];
            default:
                return "";
        }

    }

}
