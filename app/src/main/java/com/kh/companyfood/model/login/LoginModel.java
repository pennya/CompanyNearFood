package com.kh.companyfood.model.login;

import android.util.Log;

import com.kh.companyfood.define.Define;
import com.kh.companyfood.model.Status;
import com.kh.companyfood.model.User;
import com.kh.companyfood.network.LoginService;
import com.kh.companyfood.network.NetworkManager;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
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

        Call<Status> LoginCall = loginService.loginUser(id, pw);
        LoginCall.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                Log.d(TAG, "requestLogin onResponse");

                // 응답 성공
                if(response.isSuccessful()) {
                    int status = response.body().getStatus();

                    // 로그인 성공
                    if(status == Define.LOGIN_SUCCESS)
                        loginCallback.getNetworkResponse("[Login Success]", Define.LOGIN_SUCCESS);

                    // 로그인 실패
                    else {
                        loginCallback.getNetworkResponse("[Login Failed]\nCheck your id or password", Define.LOGIN_FAILED);
                    }
                } else {
                    // 응답 실패
                    int StatusCode = response.code();
                    try {
                        loginCallback.getNetworkResponse("[Login Fail]\n" + "StatusCode : " + StatusCode + "\n" + "ErrorMsg : " + response.errorBody().string(),
                                Define.RESPONSE_FAILED);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Log.d(TAG, "requestLogin onFailure");
                loginCallback.getNetworkResponse(t.getMessage(), Define.NETWORK_FAILED);
            }
        });
    }


    public void requestSignUp(String id, String pw, String email)
    {
        LoginService loginService = NetworkManager.getIntance().getRetrofit(LoginService.class);

        User user = new User();
        user.setId(id);
        user.setPassword(pw);
        user.setEmail(email);
        Call<User> signUpCall = loginService.signUpUser(user);
        signUpCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    loginCallback.getNetworkResponse("[SignUp Success]", Define.SIGNUP_SUCCESS);
                } else {
                    // 응답 실패
                    int StatusCode = response.code();
                    try {
                        loginCallback.getNetworkResponse("[SignUp Fail]\n" + "StatusCode : " + StatusCode + "\n" + "ErrorMsg : " + response.errorBody().string(),
                                Define.RESPONSE_FAILED);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loginCallback.getNetworkResponse(t.getMessage(), Define.NETWORK_FAILED);
            }
        });
    }

}
