package de.softinva.multitimer.utility;

import android.util.Log;

import de.softinva.multitimer.BuildConfig;

public class AppLogger {
    private Object classObject;

    public AppLogger(Object classObject) {
        this.classObject = classObject;
    }

    public void setClassObject(Object classObject) {
        this.classObject = classObject;
    }

    public void verbose(Object classObject, String msg) {
        logMessage(msg, Log.VERBOSE);
    }

    public void verbose(String msg, Object object) {
        logMessageAndObject(msg, object, Log.VERBOSE);
    }

    public void verbose(String msg, Throwable tr) {
        logMessageAndThrowable(msg, tr, Log.VERBOSE);
    }


    public void debug(String msg) {
        logMessage(msg, Log.DEBUG);
    }

    public void debug(String msg, Object object) {
        logMessageAndObject(msg, object, Log.DEBUG);
    }

    public void debug(String msg, Throwable tr) {
        logMessageAndThrowable(msg, tr, Log.DEBUG);
    }


    public void info(String msg) {
        logMessage(msg, Log.INFO);
    }

    public void info(String msg, Object object) {
        logMessageAndObject(msg, object, Log.INFO);
    }

    public void info(String msg, Throwable tr) {
        logMessageAndThrowable(msg, tr, Log.INFO);
    }


    public void warning(String msg) {
        logMessage(msg, Log.WARN);
    }

    public void warning(String msg, Object object) {
        logMessageAndObject(msg, object, Log.WARN);
    }

    public void warning(String msg, Throwable tr) {
        logMessageAndThrowable(msg, tr, Log.WARN);
    }


    public void error(String msg) {
        logMessage(msg, Log.ERROR);
    }

    public void error(String msg, Object object) {
        logMessageAndObject(msg, object, Log.ERROR);
    }

    public void error(String msg, Throwable tr) {
        logMessageAndThrowable(msg, tr, Log.ERROR);
    }

    public void wtf(String msg) {
        logMessage(msg, Log.ASSERT);
    }

    public void wtf(String msg, Object object) {
        logMessageAndObject(msg, object, Log.ASSERT);
    }

    public void wtf(String msg, Throwable tr) {
        logMessageAndThrowable(msg, tr, Log.ASSERT);
    }


    private String createTagAndSetSystemProp() {
        String tag = CONSTANTS.Logger_PREFIX + getClassName();
        return tag;
    }

    private String getClassName() {
        return classObject.getClass().getName().replace("de.softinva.multitimer.","");
    }

    private boolean isMsgLoggable(int logLevel) {

        String levelConfig = BuildConfig.logLevel;
        switch (levelConfig.toLowerCase()) {
            case "verbose":
                return logLevel >= Log.VERBOSE;
            case "debug":
                return logLevel >= Log.DEBUG;
            case "info":
                return logLevel >= Log.INFO;
            case "warn":
                return logLevel >= Log.WARN;
            case "error":
                return logLevel >= Log.ERROR;
            case "assert":
                return logLevel >= Log.ASSERT;
        }
        Log.e(createTagAndSetSystemProp(), "log level is not supported: "+levelConfig);
        throw new Error("error in is MsgLoggable()");
    }

    private void logMessage(String msg, int level) {
        if (isMsgLoggable(level)) {
            String tag = createTagAndSetSystemProp();
            Log.println(level, tag, msg);
        }
    }

    private void logMessageAndObject(String msg, Object object, int level) {
        if (isMsgLoggable(level)) {
            String tag = createTagAndSetSystemProp();
            Log.println(level, tag, msg + object);
        }

    }

    private void logMessageAndThrowable(String msg, Throwable tr, int level) {
        String tag = createTagAndSetSystemProp();
        if (isMsgLoggable(level)) {
            switch (level) {
                case Log.VERBOSE:
                    Log.v(tag, msg, tr);
                    break;
                case Log.DEBUG:
                    Log.d(tag, msg, tr);
                    break;
                case Log.INFO:
                    Log.i(tag, msg, tr);
                    break;
                case Log.WARN:
                    Log.w(tag, msg, tr);
                    break;
                case Log.ERROR:
                    Log.e(tag, msg, tr);
                    break;
                case Log.ASSERT:
                    Log.wtf(tag, msg, tr);
                    break;
                default:
                    Log.e(createTagAndSetSystemProp(), "Log level not exists! "+ level);
            }
        }

    }
}
