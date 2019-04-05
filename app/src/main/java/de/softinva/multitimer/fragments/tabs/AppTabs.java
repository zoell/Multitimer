package de.softinva.multitimer.fragments.tabs;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.ViewPager;
import de.softinva.multitimer.MainActivityViewModel;
import de.softinva.multitimer.R;
import de.softinva.multitimer.model.Tabs;

public class AppTabs extends Fragment {

    private AppTabsViewModel mViewModel;
    private AppTabsAdapter appTabsAdapter;
    ViewPager viewPager;
    String[] tabTitel;

    public static AppTabs newInstance() {
        return new AppTabs();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_tabs, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AppTabsViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tabTitel = new String[3];
        tabTitel[0] = getString(R.string.tab_title_1);
        tabTitel[1] = getString(R.string.tab_title_2);
        tabTitel[2] = getString(R.string.tab_title_3);
        appTabsAdapter = new AppTabsAdapter(getChildFragmentManager(), this.tabTitel);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(appTabsAdapter);
        viewPager.addOnPageChangeListener(this.onPageChangeListener);
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            MainActivityViewModel  model = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
            model.getActiveTab().setValue(Tabs.values()[position]);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
