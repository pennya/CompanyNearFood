package com.kh.companyfood.model.setting;

import android.util.Log;

import com.kh.companyfood.model.Restaurant;
import com.kh.companyfood.network.NetworkManager;
import com.kh.companyfood.network.SettingService;
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

    public SettingModel(SettingCallback mSettingCallback) {
        this.mSettingCallback = mSettingCallback;
    }

    public void requestVersion () {
        SettingService settingService = NetworkManager.getIntance().getRetrofit(SettingService.class);
        Call<Version> versions = settingService.getVersions();
        versions.enqueue(new Callback<Version>() {
            @Override
            public void onResponse(Call<Version> call, Response<Version> response) {
                if(response.isSuccessful()) {
                    Version version = response.body();

                    String versionCode = version.getVersionName();
                    mSettingCallback.getNetworkResponse(versionCode, 200);
                } else {
                    int StatusCode = response.code();
                    try {
                        mSettingCallback.getNetworkResponse("Failed", StatusCode);
                        Log.i("KJH", "Status Code : " + StatusCode + " Error Message : " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Version> call, Throwable t) {
                Log.i("KJH", " Error Message : " + t.getMessage());
            }
        });
    }
}
