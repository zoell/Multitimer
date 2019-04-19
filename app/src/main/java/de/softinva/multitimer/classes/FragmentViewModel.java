package de.softinva.multitimer.classes;

import androidx.lifecycle.ViewModel;
import de.softinva.multitimer.utility.AppLogger;

public class FragmentViewModel extends ViewModel {
    protected AppLogger logger = new AppLogger(this);
    public FragmentViewModel(){
        super();
    }
}
