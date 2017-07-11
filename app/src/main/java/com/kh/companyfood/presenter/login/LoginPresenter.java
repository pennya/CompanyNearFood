package com.kh.companyfood.presenter.login;

/**
 * Created by teruten on 2017-06-07.
 */

public interface LoginPresenter {

    void actionLogin(String id, String pw);

    interface View{
        void moveMainActivity();
        void showToast(String text);
        void actionResult(int loginSuccess);
    }
}
