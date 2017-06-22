package com.kh.companyfood.presenter.main;

/**
 * Created by KIM on 2017-06-22.
 */

public class SettingPresenterImpl implements SettingContract.Presenter {

    private SettingContract.View mSettingContractView;

    public SettingPresenterImpl(SettingContract.View SettingContractView) {
        mSettingContractView = SettingContractView;
        mSettingContractView.setPresenter(this);
    }
}
