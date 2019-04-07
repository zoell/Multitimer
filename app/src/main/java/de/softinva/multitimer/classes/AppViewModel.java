package de.softinva.multitimer.classes;

import androidx.lifecycle.ViewModel;
import de.softinva.multitimer.Utility.AppLogger;

public class AppViewModel extends ViewModel {
    protected AppLogger logger = new AppLogger(this);
    public AppViewModel(){
        super();
    }
}
