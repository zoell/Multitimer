package de.softinva.multitimer.classes;


import android.os.CountDownTimer;

import de.softinva.multitimer.model.RunningTimer;
import de.softinva.multitimer.utility.AppLogger;
import de.softinva.multitimer.utility.UtilityMethods;

public class AppCountDown {
    protected CountDownTimer countDownTimer;
    protected AppLogger logger;
    protected RunningTimer runningTimer;

    public AppCountDown(RunningTimer runningTimer) {
        logger = UtilityMethods.createLogger(this);
        this.runningTimer = runningTimer;

        countDownTimer = new CountDownTimer(runningTimer.getTimer().durationInSec * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                runningTimer.getCountDownInSec().setValue(millisUntilFinished / 1000);
                logger.info(runningTimer.getTimer().title + ": seconds remaining " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                runningTimer.setToStop();
                logger.info(runningTimer.getTimer().title + " timer stopped running!");
            }
        };
    }

    public void run() {
        logger.info("start timer: " + runningTimer.getTimer().title);
        runningTimer.setToStart();
        countDownTimer.start();
    }

    public void cancel() {
        logger.info("on cancel Timer: " + runningTimer.getTimer().title);
        runningTimer.setToStop();
        countDownTimer.cancel();
    }
}