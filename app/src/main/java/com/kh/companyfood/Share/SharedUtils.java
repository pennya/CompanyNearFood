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
                = context.getSharedPreferences(SettingTabFragment.SETTING_PREF_USER, Context.MODE_PRIVATE);

        return sharedPreferences;
    }

    public static boolean getLoginState(Context context) {
        return getSharedPref(context).getBoolean(SettingTabFragment.IS_LOGIN, false);
    }

    public static void setLoginState(Context context, boolean state) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putBoolean(SettingTabFragment.IS_LOGIN, state);
        editor.commit();
    }

    public static String getCurrentLoginId(Context context) {
         return getSharedPref(context).getString(SettingTabFragment.CURRENT_LOGIN_ID, "");
    }

    public static void setCurrentLoginId(Context context, String id) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putString(SettingTabFragment.CURRENT_LOGIN_ID, id);
        editor.commit();
    }

    public static String getAutoLoginId(Context context) {
        return getSharedPref(context).getString(SettingTabFragment.LOGIN_ID, "");
    }

    public static String getAutoLoginPassword(Context context) {
        return getSharedPref(context).getString(SettingTabFragment.LOGIN_PASSWORD, "");
    }

    public static void setAutoLoginId(Context context, String id) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putString(SettingTabFragment.LOGIN_ID, id);
        editor.commit();
    }

    public static void setAutoLoginPassword(Context context, String password) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putString(SettingTabFragment.LOGIN_PASSWORD, password);
        editor.commit();
    }

    public static boolean getAutoLoginState(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(SettingTabFragment.KEY_PREF_AUTOLOGIN, false);
    }
}
