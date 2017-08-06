package com.kh.companyfood.model.setting;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.kh.companyfood.Share.SharedUtils;
import com.kh.companyfood.model.Restaurant;
import com.kh.companyfood.network.NetworkManager;
import com.kh.companyfood.network.SettingService;
import com.kh.companyfood.ui.setting.SettingTabFragment;
import com.kh.companyfood.vo.Version;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KIM on 2017-07-26.
 */

public class SettingModel {

    private SettingCallback mSettingCallback;

    private Context mContext;

    public SettingModel(Context context, SettingCallback settingCallback) {
        this.mContext = context;
        this.mSettingCallback = settingCallback;
    }

    public void requestVersion () {
        PackageInfo packageInfo = null;
        try {
            packageInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        String versionCode = packageInfo.versionName;
        mSettingCallback.getVersionResponse(versionCode);
    }

    public void requestCurrentLoginId() {
        boolean prefLogonCurrentState
                = SharedUtils.getBooleanValue(mContext, SettingTabFragment.IS_LOGIN);

        if(prefLogonCurrentState) {
            mSettingCallback.getCurrentLoginIdResponse(
                    SharedUtils.getStringValue(mContext, SettingTabFragment.CURRENT_LOGIN_ID)
            );
        }
    }

    public void requestLogout() {
        SharedUtils.setBooleanValue(mContext, SettingTabFragment.IS_LOGIN, false);
        SharedUtils.setStringValue(mContext, SettingTabFragment.CURRENT_LOGIN_ID, "");
        mSettingCallback.getLogoutResponse("");
    }
}
