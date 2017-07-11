package com.kh.companyfood.presenter.signUp;

import android.content.Context;

import com.kh.companyfood.define.Define;
import com.kh.companyfood.model.signup.SignUpCallback;
import com.kh.companyfood.model.signup.SignUpModel;
import com.kh.companyfood.vo.User;

/**
 * Created by teruten on 2017-06-27.
 */

public class SignUpPresenterImpl implements SignUpPresenter , SignUpCallback {

    private SignUpPresenter.View view;
    private SignUpModel signUpModel;
    private Context context;

    public SignUpPresenterImpl(Context context, SignUpPresenter.View view){
        this.context = context;
        this.view = view;
        signUpModel = new SignUpModel(this);
    }

    @Override
    public void actionJoinUser(User user) {
        signUpModel.requestSignUp(user);
    }

    @Override
    public void getNetworkResponse(String text, int status) {
        if(status == Define.SIGNUP_SUCCESS){
            view.moveMainActivity();
        }else{
            view.showToast("fail");
        }

    }
}
