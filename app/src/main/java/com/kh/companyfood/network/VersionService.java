package com.kh.companyfood.network;

import com.kh.companyfood.vo.User;
import com.kh.companyfood.vo.Version;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by teruten on 2017-06-07.
 */

public interface VersionService {

    @GET("/api/versions/")
    Call<Version> requestVersion();
}
