package com.kh.companyfood.presenter.setting;

import android.content.Context;

import com.kh.companyfood.model.setting.SettingCallback;
import com.kh.companyfood.model.setting.SettingModel;

/**
 * Created by KIM on 2017-06-22.
 */

public class SettingPresenterImpl implements SettingPresenter, SettingCallback {

    private SettingPresenter.View mView;

    private SettingModel mSettingModel;

    public SettingPresenterImpl(Context context, SettingPresenter.View view) {
        mView = view;
        mSettingModel = new SettingModel(context, this);
    }

    @Override
    public void getVersionResponse(String text) {
        mView.setVersion(text);
    }

    @Override
    public void getCurrentLoginIdResponse(String text) {
        mView.setCurrentLoginId(text);
    }

    @Override
    public void loadVersion() {
        mSettingModel.requestVersion();
    }

    @Override
    public void loadCurrentLoginId() {
        mSettingModel.requestCurrentLoginId();
    }

    @Override
    public void logout() {
        mSettingModel.requestLogout();
    }

    @Override
    public void getLogoutResponse(String text) {
        mView.setCurrentLoginId(text);
        mView.moveLoginActivity();
    }
}
