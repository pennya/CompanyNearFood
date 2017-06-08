package com.kh.companyfood.network;

import com.kh.companyfood.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by teruten on 2017-06-07.
 */

public interface LoginService {

    @POST("users/create")
    Call<User> createUser(@Body User user);

    @FormUrlEncoded
    @POST("posts/1")
    Call<User> loginUser(@Field("login_id") String id, @Field("login_pw") String pw);

    @GET("posts/1")
    Call<String> getTest();
}
