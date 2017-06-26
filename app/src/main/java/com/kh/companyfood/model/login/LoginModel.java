package com.kh.companyfood.model.login;

import android.util.Log;

import com.kh.companyfood.define.Define;
import com.kh.companyfood.vo.APIError;
import com.kh.companyfood.vo.Status;
import com.kh.companyfood.vo.User;
import com.kh.companyfood.network.LoginService;
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
    private final String TAG = "KJH";
    LoginCallback loginCallback;

    public LoginModel(LoginCallback loginCallback){
        this.loginCallback = loginCallback;
    }

    public void requestLogin(String id, String pw){
        LoginService loginService = NetworkManager.getIntance().getRetrofit(LoginService.class);

        Call<User> LoginCall = loginService.loginUser(id, pw);
        LoginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "requestLogin onResponse");
                Log.d(TAG, "response.code() : "+response.code());
                // 응답 성공
                if(response.isSuccessful() && response.code() == 200) {

                    User user = response.body();
                    // 로그인 성공
                    /*if(status == Define.LOGIN_SUCCESS)
                        loginCallback.getNetworkResponse(user, Define.LOGIN_SUCCESS);

                    // 로그인 실패
                    else {
                        loginCallback.getNetworkResponse(null, Define.LOGIN_FAILED);
                    }*/

                    loginCallback.getNetworkResponse(null, Define.LOGIN_FAILED);
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
                        loginCallback.getNetworkResponse(null, Define.LOGIN_FAILED);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "requestLogin onFailure");
               //loginCallback.getNetworkResponse(t.getMessage(), Define.NETWORK_FAILED);
                loginCallback.getNetworkResponse(null, Define.LOGIN_FAILED);
            }
        });
    }



}
