package de.softinva.multitimer.utility;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class AppProperties {
    protected static AppProperties instance;
    private static Properties properties;

    private AppProperties(){

    }
    public static  AppProperties getInstance(Context context) throws IOException {
        if(instance == null){
            instance = new AppProperties();
            InputStream input = context.getAssets().open( "config.properties" );
            properties = new Properties();
            properties.load(input);
        }

       return instance;
    }
    public String get(String key) {
        return properties.getProperty(key);
    }
}
