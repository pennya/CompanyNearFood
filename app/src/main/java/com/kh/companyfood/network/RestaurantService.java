package com.kh.companyfood.network;

import com.kh.companyfood.vo.RestaurantDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KIM on 2017-08-09.
 */

public interface RestaurantService {
    @GET("/api/detail_restaurants/")
    Call<List<RestaurantDetail>> getRestaurants();
}
