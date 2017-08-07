package com.kh.companyfood.model.login;

import android.content.Context;
import android.util.Log;

import com.kh.companyfood.Share.SharedUtils;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.ui.setting.SettingTabFragment;
import com.kh.companyfood.vo.APIError;
import com.kh.companyfood.vo.User;
import com.kh.companyfood.network.UserService;
import com.kh.companyfood.network.NetworkManager;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by teruten on 2017-06-07.
 */

public class LoginModel {
    private LoginCallback mLoginCallback;

    private Context mContext;

    public LoginModel(Context context, LoginCallback loginCallback){
        mContext = context;
        mLoginCallback = loginCallback;
    }

    public void requestLogin(String id, String pw){
        UserService userService = NetworkManager.getIntance().getRetrofit(UserService.class);

        Call<User> LoginCall = userService.loginUser(id, pw);
        LoginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(Define.LOG_TAG, "requestLogin onResponse");
                Log.d(Define.LOG_TAG, "response.code() : "+response.code());
                // 응답 성공
                if(response.isSuccessful()) {
                    // 로그인 성공
                    User user = response.body();
                    savePref(user.getId(), user.getPassword());
                    mLoginCallback.getNetworkResponse(user, Define.LOGIN_SUCCESS);
                } else {
                    // 응답 실패
                    int StatusCode = response.code();

                    Converter<ResponseBody, APIError> responseBodyObjectConverter = NetworkManager.retrofit.responseBodyConverter(APIError.class, new Annotation[0]);
                    APIError convert = null;
                    try {
                        convert = responseBodyObjectConverter.convert(response.errorBody());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        //loginCallback.getNetworkResponse("[Login Fail]\n" + "StatusCode : " + StatusCode + "\n" + "ErrorMsg : " + response.errorBody().string(),Define.RESPONSE_FAILED);
                        mLoginCallback.getNetworkResponse(null, Define.LOGIN_FAILED);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(Define.LOG_TAG, "requestLogin onFailure");
                mLoginCallback.getNetworkResponse(null, Define.LOGIN_FAILED);
            }
        });
    }

    private void savePref(String id, String pw) {
        SharedUtils.setStringValue(mContext, SettingTabFragment.LOGIN_ID, id);
        SharedUtils.setStringValue(mContext, SettingTabFragment.LOGIN_PASSWORD, pw);

        SharedUtils.setBooleanValue(mContext, SettingTabFragment.IS_LOGIN, true);
        SharedUtils.setStringValue(mContext, SettingTabFragment.CURRENT_LOGIN_ID, id);
    }


}
