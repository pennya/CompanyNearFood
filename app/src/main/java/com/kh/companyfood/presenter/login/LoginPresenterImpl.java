package com.kh.companyfood.presenter.login;

import android.app.Activity;
import android.util.Log;

import com.kh.companyfood.model.login.LoginCallback;
import com.kh.companyfood.model.login.LoginModel;

/**
 * Created by teruten on 2017-06-07.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginCallback {

    private LoginPresenter.View view;
    private Activity activity;
    private LoginModel loginModel;

    public LoginPresenterImpl(Activity activity, LoginPresenter.View view){
        this.activity = activity;
        this.view = view;
        this.loginModel = new LoginModel(this);
    }

    @Override
    public void actionLogin() {
        //view.showToast("actionLogin test");
        Log.d("test1", "LoginPresenterImpl actionLogin");
        loginModel.requestLogin();
    }

    @Override
    public void actionJoinUser() {

    }

    @Override
    public void getNetworkResponse(String text) {
        Log.d("test1", "LoginPresenterImpl getNetworkResponse");
        view.showToast(text);
    }
}
