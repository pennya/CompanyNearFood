package com.kh.companyfood.ui.main;


import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.kh.companyfood.R;

public class SettingFragment extends PreferenceFragmentCompat {

    public SettingFragment() {

    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }
}