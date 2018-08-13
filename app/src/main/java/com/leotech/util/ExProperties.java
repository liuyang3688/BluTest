package com.leotech.util;

import android.app.Activity;
import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ExProperties {
    public static Properties loadConfig(Context context, String fileName) {
        Properties properties = new Properties();
        try {
            FileInputStream s = context.openFileInput(fileName);
            properties.load(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return properties;
    }
    //保存配置文件
    public static boolean saveConfig(Context context, String fileName, Properties properties) {
        try {
            FileOutputStream s = context.openFileOutput(fileName, Activity.MODE_PRIVATE );
            properties.store(s, "");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
