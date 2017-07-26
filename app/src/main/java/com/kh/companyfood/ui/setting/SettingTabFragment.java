package com.kh.companyfood.ui.setting;


import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.kh.companyfood.R;
import com.kh.companyfood.presenter.setting.SettingPresenter;

public class SettingTabFragment extends PreferenceFragmentCompat implements SettingPresenter.View{

    public SettingTabFragment() {

    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        Preference versionPref = findPreference("version");
        versionPref.setSummary("1.0.0.0");
    }

    public static SettingTabFragment newInstance() {
        return new SettingTabFragment();
    }
}