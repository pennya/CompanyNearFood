package com.kh.companyfood.model.detail;

import android.content.Context;

import com.kh.companyfood.vo.RestaurantDetail;

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
        RestaurantDetail detail = new RestaurantDetail();
        mCallback.getNetworkResponse(detail);
    }
}
