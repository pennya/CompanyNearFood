package com.kh.companyfood.ui.setting;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.kh.companyfood.R;
import com.kh.companyfood.presenter.setting.SettingPresenter;
import com.kh.companyfood.presenter.setting.SettingPresenterImpl;
import com.kh.companyfood.ui.login.LoginActivity;

import static android.app.Activity.RESULT_OK;

public class SettingTabFragment extends PreferenceFragmentCompat
        implements SettingPresenter.View, Preference.OnPreferenceClickListener {

    public static final int SETTING_TAB_FRAGMENT = 10542;
    public static final String ID = "id";
    public static final String PASSWORD = "password";
    public static final String IS_LOGIN = "isLogin";
    public static final String SETTING_PREF_USER = "pref_user";
    public static final String TITLE_PREF_LOGIN = "Log in";
    public static final String TITLE_PREF_LOGOUT = "Log out";
    public static final String KEY_PREF_LOGON = "pref_logon";
    public static final String KEY_PREF_VERSION = "pref_version";
    public static final String KEY_PREF_NOTIFICATION = "pref_notification";

    private SettingPresenterImpl mSettingPresenter;

    public SettingTabFragment() {
        mSettingPresenter = new SettingPresenterImpl(this);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        mSettingPresenter.loadItems();

        SharedPreferences sharedPreferences
                = getContext().getSharedPreferences(SETTING_PREF_USER, Context.MODE_PRIVATE);
        boolean prefLogonCurrentState = sharedPreferences.getBoolean(IS_LOGIN, false);

        Preference PrefLogon = findPreference(KEY_PREF_LOGON);
        if(prefLogonCurrentState)
            PrefLogon.setTitle(TITLE_PREF_LOGOUT);
        else
            PrefLogon.setTitle(TITLE_PREF_LOGIN);

        PrefLogon.setOnPreferenceClickListener(this);
    }

    public static SettingTabFragment newInstance() {
        return new SettingTabFragment();
    }

    @Override
    public void getNetworkResponse(String text) {
        Preference versionPref = findPreference(KEY_PREF_VERSION);
        versionPref.setSummary(text);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch(preference.getKey()) {
            case KEY_PREF_LOGON:
                SharedPreferences sharedPreferences
                        = getContext().getSharedPreferences(SETTING_PREF_USER, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                boolean prefLogonCurrentState = sharedPreferences.getBoolean(IS_LOGIN, false);

                if(prefLogonCurrentState) {
                    // 로그아웃 과정 필요

                    editor.putBoolean(IS_LOGIN, false);
                    editor.commit();
                    preference.setTitle(TITLE_PREF_LOGIN);
                    preference.setSummary("");
                } else {
                    // 로그인 과정 필요
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent, SETTING_TAB_FRAGMENT);
                }

                break;
        }

        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if( resultCode == RESULT_OK && requestCode == SETTING_TAB_FRAGMENT) {
            SharedPreferences sharedPreferences
                    = getContext().getSharedPreferences(SETTING_PREF_USER, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putBoolean(IS_LOGIN, true);
            editor.commit();

            Preference logonPref = findPreference(KEY_PREF_LOGON);
            logonPref.setTitle(TITLE_PREF_LOGOUT);
            logonPref.setSummary(data.getStringExtra(ID));
        }
    }
}