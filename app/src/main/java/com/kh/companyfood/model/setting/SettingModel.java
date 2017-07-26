package com.kh.companyfood.model.setting;

import android.util.Log;

import com.kh.companyfood.model.Restaurant;
import com.kh.companyfood.model.Version;
import com.kh.companyfood.network.NetworkManager;
import com.kh.companyfood.network.SettingService;

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
        Call<List<Version>> versions = settingService.getVersions();
        versions.enqueue(new Callback<List<Version>>() {
            @Override
            public void onResponse(Call<List<Version>> call, Response<List<Version>> response) {
                if(response.isSuccessful()) {
                    List<Version> versionList = response.body();

                    String versionInfo = "";
                    int versionCount = versionList.size();
                    versionInfo = versionList.get(versionCount - 1).getVersionName();

                    mSettingCallback.getNetworkResponse(versionInfo, 200);
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
            public void onFailure(Call<List<Version>> call, Throwable t) {

            }
        });
    }
}
