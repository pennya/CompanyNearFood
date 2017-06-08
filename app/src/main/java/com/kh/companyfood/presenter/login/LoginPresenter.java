package com.kh.companyfood.presenter.login;

/**
 * Created by teruten on 2017-06-07.
 */

public interface LoginPresenter {

    void actionLogin();
    void actionJoinUser();

    interface View{

        void showToast(String text);
    }
}
