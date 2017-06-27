package com.kh.companyfood.network;

import com.kh.companyfood.vo.Status;
import com.kh.companyfood.vo.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by teruten on 2017-06-07.
 */

public interface UserService {
    @FormUrlEncoded
    @POST("/api/login/")
    Call<User> loginUser(@Field("id") String id, @Field("password") String pw);


    @POST("/api/users/")
    Call<User> signUpUser(@Body User user);
}
