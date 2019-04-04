package de.softinva.multitimer.repository.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.softinva.multitimer.model.AppTimer;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyTimerList {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<AppTimer> ITEMS = new ArrayList<AppTimer>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, AppTimer> ITEM_MAP = new HashMap<String, AppTimer>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(AppTimer item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static AppTimer createDummyItem(int position) {
        return new AppTimer(String.valueOf(position), "Timer " + position, makeDetails(position), 250);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

}
