package com.kh.companyfood.network;

import com.kh.companyfood.model.Status;
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
    @FormUrlEncoded
    @POST("/api/userLogin/")
    Call<Status> loginUser(@Field("id") String id, @Field("password") String pw);


    @POST("/api/users/")
    Call<User> signUpUser(@Body User user);
}
