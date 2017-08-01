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
    public static final String LOGON_ID = "logon_id";
    public static final String LOGON_PASSWORD = "logon_password";
    public static final String CURRENT_LOGON_ID = "current_logon_id";
    public static final String IS_LOGIN = "is_login";
    public static final String IS_AUTO_LOGIN = "is_auto_login";
    public static final String SETTING_PREF_USER = "pref_user";
    public static final String KEY_PREF_LOGON = "pref_logon";
    public static final String KEY_PREF_VERSION = "pref_version";
    public static final String KEY_PREF_NOTIFICATION = "pref_notification";

    public static final String TITLE_PREF_LOGIN = "Log in";
    public static final String TITLE_PREF_LOGOUT = "Log out";

    private SettingPresenterImpl mSettingPresenter;

    public SettingTabFragment() {
        mSettingPresenter = new SettingPresenterImpl(this);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        mSettingPresenter.loadItems();

        boolean prefLogonCurrentState = SharedUtils.loginCheck(getContext());

        Preference PrefLogon = findPreference(KEY_PREF_LOGON);
        if(prefLogonCurrentState) {
            PrefLogon.setTitle(TITLE_PREF_LOGOUT);
            PrefLogon.setSummary(SharedUtils.getCurrentLogonId(getContext()));
        } else {
            PrefLogon.setTitle(TITLE_PREF_LOGIN);
        }

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
                boolean prefLogonCurrentState = SharedUtils.loginCheck(getContext());
                if(prefLogonCurrentState) {
                    SharedUtils.setLoginState(getContext(), false);
                    SharedUtils.setCurrentLogonId(getContext(), "");
                    preference.setTitle(TITLE_PREF_LOGIN);
                    preference.setSummary("");
                } else {
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

        if( resultCode == LOGIN_ACTIVITY_RESULT_OK && requestCode == SETTING_TAB_FRAGMENT) {
            SharedUtils.setLoginState(getContext(), true);
            Preference logonPref = findPreference(KEY_PREF_LOGON);
            logonPref.setTitle(TITLE_PREF_LOGOUT);

            String id = SharedUtils.getCurrentLogonId(getContext());
            logonPref.setSummary(id);
        }
    }
}