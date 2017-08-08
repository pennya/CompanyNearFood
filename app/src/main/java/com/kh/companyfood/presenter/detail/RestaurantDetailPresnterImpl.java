package com.kh.companyfood.presenter.detail;

import android.content.Context;

import com.kh.companyfood.model.detail.RestaurantDetailCallback;
import com.kh.companyfood.model.detail.RestaurantDetailModel;
import com.kh.companyfood.vo.RestaurantDetail;

/**
 * Created by KIM on 2017-08-08.
 */

public class RestaurantDetailPresnterImpl implements RestaurantDetailPresnter, RestaurantDetailCallback{

    private RestaurantDetailPresnter.View mView;

    private RestaurantDetailModel mModel;

    public RestaurantDetailPresnterImpl(Context context, View view) {
        this.mView = view;
        mModel = new RestaurantDetailModel(context, this);
    }

    @Override
    public void loadDetails(int id) {
        mModel.RequestRestaurantDetail(id);
    }

    @Override
    public void getNetworkResponse(RestaurantDetail detail) {
        mView.setRestaurantDetail(detail);
    }
}
