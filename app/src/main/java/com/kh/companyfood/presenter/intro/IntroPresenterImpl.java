package com.kh.companyfood.presenter.intro;

import android.content.Context;

import com.kh.companyfood.Share.SharedUtils;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.model.intro.IntroCallback;
import com.kh.companyfood.model.intro.IntroModel;
import com.kh.companyfood.ui.setting.SettingTabFragment;

import java.lang.ref.PhantomReference;

/**
 * Created by teruten on 2017-06-07.
 */

public class IntroPresenterImpl implements IntroPresenter, IntroCallback {

    private IntroPresenter.View view;
    private IntroModel introModel;
    private Context mContext;

    public IntroPresenterImpl(Context context, IntroPresenter.View view){
        this.view = view;
        mContext = context;
        introModel = new IntroModel(context, this);
    }

    @Override
    public void onVersionCheck() {
        introModel.requestVersionCheck();
    }

    @Override
    public void getNetworkResponse(int versionStatus, int networkStatus) {
        if(versionStatus == Define.SUCCESS && networkStatus == 200){
            boolean isLogin = SharedUtils.getBooleanValue(mContext, Define.IS_LOGIN);
            if(isLogin)
                view.moveMainActivity();
            else
                view.moveLoginActivity();
        }else{
            view.showToast();
        }
    }
}
