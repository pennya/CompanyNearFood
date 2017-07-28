package com.kh.companyfood.network;

import com.kh.companyfood.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by KIM on 2017-06-26.
 */

public interface RecommandService {

    @FormUrlEncoded
    @POST("/api/recommands/")
    Call<List<Restaurant>> getRecommands(@Field("category") int[] category, @Field("weather") int[] weather, @Field("distance") int[] distance);

}
