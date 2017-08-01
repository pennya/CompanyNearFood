package com.kh.companyfood.presenter.intro;

/**
 * Created by teruten on 2017-06-07.
 */

public interface IntroPresenter {

    void actionLogin(String id, String pw);

    void onVersionCheck();

    interface View{
        void moveMainActivity();
        void moveLoginActivity();
        void showToast();
    }
}
