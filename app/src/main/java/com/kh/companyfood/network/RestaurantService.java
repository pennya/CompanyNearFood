package com.kh.companyfood.network;

import com.kh.companyfood.vo.RestaurantDetail;
import com.kh.companyfood.vo.RestaurantList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by KIM on 2017-08-09.
 */

public interface RestaurantService {
    @GET("/api/detail_restaurants/")
    Call<List<RestaurantList>> getRestaurants();

    @FormUrlEncoded
    @POST("/api/detail_restaurants/")
    Call<RestaurantDetail> getDetailRestaurant(@Field("id") int id, @Field("userId") int userId);
}
