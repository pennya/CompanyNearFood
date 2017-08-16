package com.kh.companyfood.presenter.setting;

/**
 * Created by KIM on 2017-06-22.
 */

public interface SettingPresenter {

    void loadVersion();

    void loadCurrentLoginId();

    void logout();

    interface View  {

        void setVersion(String text);

        void setCurrentLoginId(String text);

        void moveLoginActivity();
    }
}
