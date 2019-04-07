package de.softinva.multitimer.classes;

import androidx.fragment.app.Fragment;
import de.softinva.multitimer.utility.AppLogger;

public class AppFragment extends Fragment {
    protected AppLogger logger = new AppLogger(this);
    public AppFragment(){
        super();
    }
}
