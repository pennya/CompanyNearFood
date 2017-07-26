package com.kh.companyfood.network;

import com.kh.companyfood.model.Version;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KIM on 2017-07-26.
 */

public interface SettingService {

    @GET("/api/versions/")
    Call<List<Version>> getVersions();

}
