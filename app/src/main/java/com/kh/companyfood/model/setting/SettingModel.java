package com.kh.companyfood.model.setting;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.kh.companyfood.Share.SharedUtils;
import com.kh.companyfood.define.Define;

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
                = SharedUtils.getBooleanValue(mContext, Define.IS_LOGIN);

        if(prefLogonCurrentState) {
            mSettingCallback.getCurrentLoginIdResponse(
                    SharedUtils.getStringValue(mContext, Define.CURRENT_LOGIN_ID)
            );
        }
    }

    public void requestLogout() {
        SharedUtils.setBooleanValue(mContext, Define.IS_LOGIN, false);
        SharedUtils.setStringValue(mContext, Define.CURRENT_LOGIN_ID, "");
        mSettingCallback.getLogoutResponse("");
    }
}
