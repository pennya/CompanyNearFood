package com.kh.companyfood.model.restaurant;

import android.util.Log;

import com.kh.companyfood.adapter.restaurant.RecyclerViewData;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.network.NetworkManager;
import com.kh.companyfood.network.RestaurantService;
import com.kh.companyfood.vo.Image;
import com.kh.companyfood.vo.RestaurantDetail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by teruten on 2017-07-10.
 */

public class RestaurantModel {

    private ArrayList<RecyclerViewData> mDataList;
    private RestaurantCallback restaurantCallback;

    public RestaurantModel(RestaurantCallback restaurantCallback){
        mDataList = new ArrayList<>();
        this.restaurantCallback = restaurantCallback;
    }

    public void requestRestaurantList(){
        RestaurantService restaurantService = NetworkManager.getIntance().getRetrofit(RestaurantService.class);
        Call<List<RestaurantDetail>> restaurantListCall = restaurantService.getRestaurants();
        restaurantListCall.enqueue(new Callback<List<RestaurantDetail>>() {
            @Override
            public void onResponse(Call<List<RestaurantDetail>> call, Response<List<RestaurantDetail>> response) {
                if(response.isSuccessful() && response.code() == 200) {
                    List<RestaurantDetail> restaurantLists = response.body();
                    for(int i = 0; i < restaurantLists.size(); i++) {
                        RestaurantDetail resturantDetail = restaurantLists.get(i);
                        Image[] image = resturantDetail.getRestaurantimage_set();
                        float rating = Float.parseFloat(String.format("%.1f", resturantDetail.getRatingAverage()));


                        mDataList.add(new RecyclerViewData(
                                resturantDetail.getId(),
                                (image.length==0)? "http://cfs12.blog.daum.net/image/3/blog/2008/09/28/22/44/48df88026332d&filename=IMGP2487.JPG" : image[0].getPath(),
                                resturantDetail.getName(),
                                rating
                        ));
                    }
                    restaurantCallback.getNetworkResponse(mDataList, 200);
                }
            }

            @Override
            public void onFailure(Call<List<RestaurantDetail>> call, Throwable t) {
                Log.d(Define.LOG_TAG, "onFailure : " + t.getMessage());
            }
        });
    }
}
