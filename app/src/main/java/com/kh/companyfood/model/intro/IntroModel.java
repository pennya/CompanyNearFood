package com.kh.companyfood.model.intro;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.kh.companyfood.define.Define;
import com.kh.companyfood.network.NetworkManager;
import com.kh.companyfood.network.VersionService;
import com.kh.companyfood.vo.APIError;
import com.kh.companyfood.vo.Version;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by teruten on 2017-06-27.
 */

public class IntroModel {

    private IntroCallback introCallback;
    private Context context;

    public  IntroModel(Context context, IntroCallback introCallback){
        this.introCallback = introCallback;
        this.context = context;
    }

    public void requestVersionCheck(){
        VersionService versionService = NetworkManager.getIntance().getRetrofit(VersionService.class);

        Call<Version> LoginCall = versionService.requestVersion();
        LoginCall.enqueue(new Callback<Version>() {
            @Override
            public void onResponse(Call<Version> call, Response<Version> response) {
                if(response.isSuccessful() && response.code() == 200) {

                    Version version = response.body();
                    PackageInfo packageInfo = null;
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }

                    Log.d(Define.LOG_TAG, "version.getVersionName() : "+version.getVersionName());
                    Log.d(Define.LOG_TAG, "version.getVersionCode() : "+version.getVersionCode());
                    Log.d(Define.LOG_TAG, "packageInfo.versionName : "+packageInfo.versionName);
                    Log.d(Define.LOG_TAG, "packageInfo.versionCode : "+packageInfo.versionCode);

                    if(version.getVersionCode() > packageInfo.versionCode){
                        introCallback.getNetworkResponse(Define.UPDATE, 200);
                    }else{
                        introCallback.getNetworkResponse(Define.SUCCESS, 200);
                    }

                } else {
                    int StatusCode = response.code();

                    Converter<ResponseBody, APIError> responseBodyObjectConverter = NetworkManager.retrofit.responseBodyConverter(APIError.class, new Annotation[0]);
                    APIError convert = null;
                    try {
                        convert = responseBodyObjectConverter.convert(response.errorBody());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        introCallback.getNetworkResponse(Define.RESPONSE_FAILED, StatusCode);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Version> call, Throwable t) {
                introCallback.getNetworkResponse(-1, Define.NETWORK_FAILED);
            }
        });
    }
}
