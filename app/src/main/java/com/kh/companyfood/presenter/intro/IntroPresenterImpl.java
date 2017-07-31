package com.kh.companyfood.presenter.intro;

import android.content.Context;

import com.kh.companyfood.define.Define;
import com.kh.companyfood.model.intro.IntroCallback;
import com.kh.companyfood.model.intro.IntroModel;

import java.lang.ref.PhantomReference;

/**
 * Created by teruten on 2017-06-07.
 */

public class IntroPresenterImpl implements IntroPresenter, IntroCallback {

    private IntroPresenter.View view;
    private IntroModel introModel;

    public IntroPresenterImpl(Context context, IntroPresenter.View view){
        this.view = view;
        introModel = new IntroModel(context, this);
    }

    @Override
    public void onVersionCheck() {
        introModel.requestVersionCheck();
    }

    @Override
    public void getNetworkResponse(int status) {
        if(status == Define.SUCCESS){
            view.moveMainActivity();
        }else{
            view.showToast();
        }
    }
}
