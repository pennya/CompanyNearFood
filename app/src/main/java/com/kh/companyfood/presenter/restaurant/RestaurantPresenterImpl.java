package com.kh.companyfood.presenter.restaurant;

import com.kh.companyfood.adapter.restaurant.RecyclerViewAdapter;
import com.kh.companyfood.adapter.restaurant.RecyclerViewData;
import com.kh.companyfood.model.restaurant.RestaurantCallback;
import com.kh.companyfood.model.restaurant.RestaurantModel;

import java.util.ArrayList;

/**
 * Created by KIM on 2017-06-21.
 */

public class RestaurantPresenterImpl implements RestaurantPresenter, RestaurantCallback{

    private final RestaurantPresenter.View mView;

    private RestaurantModel restaurantModel;

    public RestaurantPresenterImpl(RestaurantPresenter.View view) {
        mView = view;
        restaurantModel = new RestaurantModel(this);
    }

    @Override
    public void loadItems() {
        restaurantModel.requestRestaurantList();
    }

    @Override
    public void onRecyclerItemClick(int position) {
        mView.ShowToast("StartActivity " + position);
    }

    @Override
    public void onRecyclerItemLongClick(int position) {
        mView.ShowToast("Dialog Print " + position);
    }

    @Override
    public void getNetworkResponse(ArrayList<RecyclerViewData> list, int status) {
        mView.addList(list);
    }
}
