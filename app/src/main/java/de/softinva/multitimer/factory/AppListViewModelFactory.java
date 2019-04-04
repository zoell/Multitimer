package de.softinva.multitimer.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import de.softinva.multitimer.fragments.list.AppListViewModel;
import de.softinva.multitimer.repository.TimerRepository;

public class AppListViewModelFactory implements ViewModelProvider.Factory {
    private TimerRepository timerRepo;


    public AppListViewModelFactory(TimerRepository timerRepo) {
        this.timerRepo = timerRepo;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new AppListViewModel(timerRepo);
    }
}
