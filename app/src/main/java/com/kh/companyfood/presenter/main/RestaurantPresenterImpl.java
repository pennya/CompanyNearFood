package com.kh.companyfood.presenter.main;

import android.support.annotation.NonNull;

/**
 * Created by KIM on 2017-06-21.
 */

public class RestaurantPresenterImpl implements RestaurantContract.Presenter{

    private final RestaurantContract.View mRestaurantContractView;

    public RestaurantPresenterImpl(RestaurantContract.View RestaurantContractView) {
        mRestaurantContractView = RestaurantContractView;
        mRestaurantContractView.setPresenter(this);
    }

    @Override
    public void buttonClickAction() {
        mRestaurantContractView.ShowToast("Success");
    }
}
