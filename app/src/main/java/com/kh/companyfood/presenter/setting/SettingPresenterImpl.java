package com.kh.companyfood.presenter.setting;

import com.kh.companyfood.model.setting.SettingCallback;
import com.kh.companyfood.model.setting.SettingModel;

/**
 * Created by KIM on 2017-06-22.
 */

public class SettingPresenterImpl implements SettingPresenter, SettingCallback {

    private SettingPresenter.View mView;

    private SettingModel mSettingModel;

    public SettingPresenterImpl(SettingPresenter.View view) {
        mView = view;
        mSettingModel = new SettingModel(this);
    }

    @Override
    public void loadItems() {
        mSettingModel.requestVersion();
    }

    @Override
    public void getNetworkResponse(String text, int status) {
        mView.getNetworkResponse(text);
    }
}
