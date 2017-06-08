package com.kh.companyfood.model.login;

import android.util.Log;

import com.kh.companyfood.model.User;
import com.kh.companyfood.network.LoginService;
import com.kh.companyfood.network.NetworkManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by teruten on 2017-06-07.
 */

public class LoginModel {

    LoginCallback loginCallback;

    public LoginModel(LoginCallback loginCallback){
        this.loginCallback = loginCallback;
    }

    public void requestLogin(){
        LoginService loginService = NetworkManager.getIntance().getRetrofit(LoginService.class);

        Call<String> test = loginService.getTest();
        test.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("test1", "requestLogin onResponse");
                loginCallback.getNetworkResponse("network success test");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("test1", "requestLogin onFailure");
                loginCallback.getNetworkResponse("network fail test");
            }
        });
    }
}
