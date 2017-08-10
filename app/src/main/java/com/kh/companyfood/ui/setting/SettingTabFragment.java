package com.kh.companyfood.ui.setting;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.kh.companyfood.R;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.presenter.setting.SettingPresenter;
import com.kh.companyfood.presenter.setting.SettingPresenterImpl;
import com.kh.companyfood.ui.login.LoginActivity;

public class SettingTabFragment extends PreferenceFragmentCompat
        implements SettingPresenter.View, Preference.OnPreferenceClickListener {

    private SettingPresenterImpl mSettingPresenter;

    private Preference PrefLogon;

    public SettingTabFragment() {

    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        mSettingPresenter = new SettingPresenterImpl(getActivity(), this);
        mSettingPresenter.loadVersion();

        PrefLogon = findPreference(Define.KEY_PREF_LOGON);
        PrefLogon.setOnPreferenceClickListener(this);

        mSettingPresenter.loadCurrentLoginId();
    }

    public static SettingTabFragment newInstance() {
        return new SettingTabFragment();
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch(preference.getKey()) {
            case Define.KEY_PREF_LOGON:
                mSettingPresenter.logout();
                break;
        }

        return false;
    }

    @Override
    public void setVersion(String text) {
        Preference versionPref = findPreference(Define.KEY_PREF_VERSION);
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