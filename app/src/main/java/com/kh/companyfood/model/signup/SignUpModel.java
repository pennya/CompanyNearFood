package com.kh.companyfood.model.signup;

import com.kh.companyfood.define.Define;
import com.kh.companyfood.network.LoginService;
import com.kh.companyfood.network.NetworkManager;
import com.kh.companyfood.vo.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by teruten on 2017-06-26.
 */

public class SignUpModel {

    private SignUpCallback signUpCallback;

    public SignUpModel(SignUpCallback signUpCallback){
        this.signUpCallback = signUpCallback;
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
                    signUpCallback.getNetworkResponse("[SignUp Success]", Define.SIGNUP_SUCCESS);
                } else {
                    // 응답 실패
                    int StatusCode = response.code();
                    try {
                        signUpCallback.getNetworkResponse("[SignUp Fail]\n" + "StatusCode : " + StatusCode + "\n" + "ErrorMsg : " + response.errorBody().string(),
                                Define.RESPONSE_FAILED);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                signUpCallback.getNetworkResponse(t.getMessage(), Define.NETWORK_FAILED);
            }
        });
    }
}
