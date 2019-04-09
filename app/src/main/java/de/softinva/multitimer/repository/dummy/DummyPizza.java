package de.softinva.multitimer.repository.dummy;

import java.util.ArrayList;

import de.softinva.multitimer.model.DetailedTimer;
import de.softinva.multitimer.model.TimerGroup;
import de.softinva.multitimer.utility.AppLogger;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyPizza {
    private  final ArrayList<DetailedTimer> TIMER_LIST = new ArrayList<>();
    private AppLogger logger;
    public  final TimerGroup TIMER_GROUP;


    public DummyPizza() {
        addItemToTimerList(new DetailedTimer(0, " Pizza backen", 900, "Tiefgefrorene Pizza in den Ofen tun. Ofen muss nicht vorgeheizt werden.", "pizza.png"));
        TIMER_GROUP = new TimerGroup(0, "Pizza", TIMER_LIST);
    }

    private void addItemToTimerList(DetailedTimer timer) {
        TIMER_LIST.add(timer);
    }

}
