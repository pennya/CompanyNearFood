package com.kh.companyfood.presenter.login;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.kh.companyfood.define.Define;
import com.kh.companyfood.model.login.LoginCallback;
import com.kh.companyfood.model.login.LoginModel;
import com.kh.companyfood.ui.login.LoginActivity;
import com.kh.companyfood.ui.main.MainActivity;

/**
 * Created by teruten on 2017-06-07.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginCallback {
    private final String TAG = "KJH";
    private LoginPresenter.View view;
    private Activity activity;
    private LoginModel loginModel;

    public LoginPresenterImpl(Activity activity, LoginPresenter.View view){
        this.activity = activity;
        this.view = view;
        this.loginModel = new LoginModel(this);
    }

    @Override
    public void actionLogin(String id, String pw) {
        Log.d(TAG, "LoginPresenterImpl actionLogin");
        loginModel.requestLogin(id, pw);
    }

    @Override
    public void actionJoinUser(String id, String pw, String email) {
        loginModel.requestSignUp(id, pw, email);
    }

    @Override
    public void getNetworkResponse(String text, int status) {
        Log.d(TAG, "LoginPresenterImpl getNetworkResponse");
        view.showToast(text);
        view.actionResult(status);
    }
}
