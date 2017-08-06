package com.kh.companyfood.Share;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.kh.companyfood.ui.setting.SettingTabFragment;

/**
 * Created by KIM on 2017-08-01.
 */

public class SharedUtils {

    public static SharedPreferences getSharedPref(Context context) {
        SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences;
    }

    public static boolean getBooleanValue(Context context, String key) {
        return getSharedPref(context).getBoolean(key, false);
    }

    public static int getIntValue(Context context, String key) {
        return getSharedPref(context).getInt(key, -1);
    }

    public static String getStringValue(Context context, String key) {
        return getSharedPref(context).getString(key, null);
    }

    public static void setBooleanValue(Context context, String key, boolean state) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putBoolean(key, state);
        editor.commit();
    }

    public static void setIntValue(Context context, String key, int value) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void setStringValue(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putString(key, value);
        editor.commit();
    }
}
