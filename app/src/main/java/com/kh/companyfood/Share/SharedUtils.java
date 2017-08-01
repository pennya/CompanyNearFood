package com.kh.companyfood.Share;

import android.content.Context;
import android.content.SharedPreferences;

import com.kh.companyfood.ui.setting.SettingTabFragment;

/**
 * Created by KIM on 2017-08-01.
 */

public class SharedUtils {

    public static boolean loginCheck(Context context) {
        SharedPreferences sharedPreferences
                = context.getSharedPreferences(SettingTabFragment.SETTING_PREF_USER, Context.MODE_PRIVATE);

        return sharedPreferences.getBoolean(SettingTabFragment.IS_LOGIN, false);
    }

    public static void setLoginState(Context context, boolean state) {
        SharedPreferences sharedPreferences
                = context.getSharedPreferences(SettingTabFragment.SETTING_PREF_USER, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SettingTabFragment.IS_LOGIN, state);
        editor.commit();
    }

    public static String getCurrentLogonId(Context context) {
        SharedPreferences sharedPreferences
                = context.getSharedPreferences(SettingTabFragment.SETTING_PREF_USER, Context.MODE_PRIVATE);

        return sharedPreferences.getString(SettingTabFragment.CURRENT_LOGON_ID, "");
    }

    public static void setCurrentLogonId(Context context, String id) {
        SharedPreferences sharedPreferences
                = context.getSharedPreferences(SettingTabFragment.SETTING_PREF_USER, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SettingTabFragment.CURRENT_LOGON_ID, id);
        editor.commit();
    }

    public static String getSavedId(Context context) {
        SharedPreferences sharedPreferences
                = context.getSharedPreferences(SettingTabFragment.SETTING_PREF_USER, Context.MODE_PRIVATE);

        return sharedPreferences.getString(SettingTabFragment.LOGON_ID, "");
    }

    public static String getSavedPassword(Context context) {
        SharedPreferences sharedPreferences
                = context.getSharedPreferences(SettingTabFragment.SETTING_PREF_USER, Context.MODE_PRIVATE);

        return sharedPreferences.getString(SettingTabFragment.LOGON_PASSWORD, "");
    }

    public static void setAutoLoginId(Context context, String id) {
        SharedPreferences sharedPreferences
                = context.getSharedPreferences(SettingTabFragment.SETTING_PREF_USER, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SettingTabFragment.LOGON_ID, id);
        editor.commit();
    }

    public static void setAutoLoginPassword(Context context, String password) {
        SharedPreferences sharedPreferences
                = context.getSharedPreferences(SettingTabFragment.SETTING_PREF_USER, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SettingTabFragment.LOGON_PASSWORD, password);
        editor.commit();
    }
}
