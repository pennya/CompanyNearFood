package com.kh.companyfood.ui.setting;


import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.kh.companyfood.R;

public class SettingTabFragment extends PreferenceFragmentCompat {

    public SettingTabFragment() {

    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

    public static SettingTabFragment newInstance() {
        return new SettingTabFragment();
    }
}