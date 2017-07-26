package com.kh.companyfood.ui.setting;


import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.kh.companyfood.R;
import com.kh.companyfood.model.setting.SettingCallback;
import com.kh.companyfood.model.setting.SettingModel;
import com.kh.companyfood.presenter.setting.SettingPresenter;
import com.kh.companyfood.presenter.setting.SettingPresenterImpl;

public class SettingTabFragment extends PreferenceFragmentCompat implements SettingPresenter.View{

    private SettingPresenterImpl mSettingPresenter;

    public SettingTabFragment() {
        mSettingPresenter = new SettingPresenterImpl(this);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        mSettingPresenter.loadItems();
    }

    public static SettingTabFragment newInstance() {
        return new SettingTabFragment();
    }

    @Override
    public void getNetworkResponse(String text) {
        Preference versionPref = findPreference("version");
        versionPref.setSummary(text);
    }
}