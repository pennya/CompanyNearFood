package com.kh.companyfood.presenter.signUp;

import com.kh.companyfood.vo.User;

/**
 * Created by teruten on 2017-06-27.
 */

public interface SignUpPresenter {

    void actionJoinUser(User user);

    interface View{
        void moveMainActivity();
        void showToast(String text);
        void actionResult(int loginSuccess);
    }
}
