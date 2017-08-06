package com.kh.companyfood.ui.setting;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.kh.companyfood.R;
import com.kh.companyfood.Share.SharedUtils;
import com.kh.companyfood.presenter.setting.SettingPresenter;
import com.kh.companyfood.presenter.setting.SettingPresenterImpl;
import com.kh.companyfood.ui.login.LoginActivity;

public class SettingTabFragment extends PreferenceFragmentCompat
        implements SettingPresenter.View, Preference.OnPreferenceClickListener {

    public static final int SETTING_TAB_FRAGMENT = 10542;
    public static final int LOGIN_ACTIVITY_RESULT_OK = 1;
    public static final String LOGIN_ID = "login_id";
    public static final String LOGIN_PASSWORD = "login_password";
    public static final String CURRENT_LOGIN_ID = "current_login_id";
    public static final String IS_LOGIN = "is_login";
    public static final String KEY_PREF_LOGON = "pref_logon";
    public static final String KEY_PREF_VERSION = "pref_version";
    public static final String KEY_PREF_NOTIFICATION = "pref_notification";
    public static final String KEY_PREF_AUTOLOGIN = "pref_autologin";

    private SettingPresenterImpl mSettingPresenter;

    private Preference PrefLogon;

    public SettingTabFragment() {

    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        mSettingPresenter = new SettingPresenterImpl(getActivity(), this);
        mSettingPresenter.loadVersion();

        PrefLogon = findPreference(KEY_PREF_LOGON);
        PrefLogon.setOnPreferenceClickListener(this);

        mSettingPresenter.loadCurrentLoginId();
    }

    public static SettingTabFragment newInstance() {
        return new SettingTabFragment();
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch(preference.getKey()) {
            case KEY_PREF_LOGON:
                mSettingPresenter.logout();
                break;
        }

        return false;
    }

    @Override
    public void setVersion(String text) {
        Preference versionPref = findPreference(KEY_PREF_VERSION);
        versionPref.setSummary(text);
    }

    @Override
    public void setCurrentLoginId(String text) {
        PrefLogon.setSummary(text);
    }

    @Override
    public void moveLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}