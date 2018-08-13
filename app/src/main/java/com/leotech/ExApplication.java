package com.blutest.ly;

import android.app.Application;

import java.util.Properties;

public class ExApplication extends Application {
    private Properties prop = null;

    public void setProp(Properties prop) {
        if (prop != null) {
            this.prop = prop;
        }
    }
    public void setPropValue(String key, String value) {
        this.prop.setProperty(key, value);
    }

    public String getPropValue(String key) {
        return this.prop.getProperty(key);
    }
}
