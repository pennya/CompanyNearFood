package com.kh.companyfood.model.detail;

import android.content.Context;
import android.util.Log;

import com.kh.companyfood.Share.SharedUtils;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.network.NetworkManager;
import com.kh.companyfood.network.RestaurantService;
import com.kh.companyfood.vo.RestaurantDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KIM on 2017-08-08.
 */

public class RestaurantDetailModel {

    private Context mContext;

    private RestaurantDetailCallback mCallback;

    public RestaurantDetailModel(Context context, RestaurantDetailCallback callback) {
        this.mContext = context;
        this.mCallback = callback;
    }

    public void RequestRestaurantDetail(int id) {
        RestaurantService restaurantService = NetworkManager.getIntance().getRetrofit(RestaurantService.class);

        int userId = SharedUtils.getIntValue(mContext, Define.ID_PK);
        Call<RestaurantDetail> callRestaurantDetail = restaurantService.getDetailRestaurant(id, userId);
        callRestaurantDetail.enqueue(new Callback<RestaurantDetail>() {
            @Override
            public void onResponse(Call<RestaurantDetail> call, Response<RestaurantDetail> response) {
                if(response.isSuccessful() && response.code() == 200) {
                    RestaurantDetail restaurantDetail= response.body();
                    mCallback.getNetworkResponse(restaurantDetail, 200);
                }
            }

            @Override
            public void onFailure(Call<RestaurantDetail> call, Throwable t) {
                Log.d(Define.LOG_TAG, "onFailure : " + t.getMessage());
            }
        });
    }
}
