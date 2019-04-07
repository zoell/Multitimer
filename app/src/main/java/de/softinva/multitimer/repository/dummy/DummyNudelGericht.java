package de.softinva.multitimer.repository.dummy;
import java.util.ArrayList;

import de.softinva.multitimer.utility.AppLogger;
import de.softinva.multitimer.model.DetailedTimer;
import de.softinva.multitimer.model.TimerGroup;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyNudelGericht {
    private  final ArrayList<DetailedTimer> TIMER_LIST = new ArrayList<>();
    private AppLogger logger;
    public  final TimerGroup TIMER_GROUP;


    public DummyNudelGericht() {
        addItemToTimerList(new DetailedTimer(0, "Nudeln", 480, "Nudeln zum kochen bringen und dann auf mittlere Stufe herunter stellen.", "nudeln.png"));
        addItemToTimerList(new DetailedTimer(1, "Tomatensoße", 480, "Tomatensoße auf mittlerer Stufe erwärmen.", "nudeln.png"));
        TIMER_GROUP = new TimerGroup(0, "Nudeln", TIMER_LIST);
    }

    private void addItemToTimerList(DetailedTimer timer) {
        TIMER_LIST.add(timer);
    }

}
