package de.softinva.multitimer.fragments.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import de.softinva.multitimer.fragments.list.AppList;



public class AppTabsAdapter extends FragmentPagerAdapter{
    String[] tabTitel;
    public AppTabsAdapter(FragmentManager fm, String[] tabTitles) {
        super(fm);
        this.tabTitel = tabTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
            default:
                AppList tab1 = new AppList();
                return tab1;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return  tabTitel[0];
            case 1:
                return tabTitel[1];
            case 2:
                return tabTitel[2];
            default:
                return "";
        }

    }

}
