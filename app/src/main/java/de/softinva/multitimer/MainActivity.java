package de.softinva.multitimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.logging.LogManager;

import de.softinva.multitimer.model.Timer;
import de.softinva.multitimer.fragments.list.AppList;
import de.softinva.multitimer.model.TimerGroup;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLoggingConfiguration();

    }

    private void setLoggingConfiguration() {
        System.setProperty("java.util.logging.config.file", "logging.properties");


        try {
            LogManager.getLogManager().readConfiguration();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
