package com.kh.companyfood.model.restaurant;

import com.kh.companyfood.adapter.restaurant.RecyclerViewData;

import java.util.ArrayList;

/**
 * Created by teruten on 2017-07-10.
 */

public interface RestaurantCallback {
    void getNetworkResponse(ArrayList<RecyclerViewData> list, int status);
}
