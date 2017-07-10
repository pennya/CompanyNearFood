package com.kh.companyfood.presenter.restaurant;

/**
 * Created by KIM on 2017-06-21.
 */

public interface RestaurantPresenter {

    void loadItems();

    void onRecyclerItemClick(int position);

    void onRecyclerItemLongClick(int position);

    interface View {

        void ShowToast(String msg);

    }
}



