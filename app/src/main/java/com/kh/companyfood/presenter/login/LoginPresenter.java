package com.kh.companyfood.presenter.login;

/**
 * Created by teruten on 2017-06-07.
 */

public interface LoginPresenter {

    void actionLogin(String id, String pw);
    void actionJoinUser(String id, String pw, String email);

    interface View{

        void showToast(String text);
        void actionResult(int loginSuccess);
    }
}
