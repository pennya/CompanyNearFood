package com.kh.companyfood.presenter.main;

import com.kh.companyfood.ui.main.RecyclerViewData;

import java.util.ArrayList;

/**
 * Created by KIM on 2017-06-21.
 */

public interface RestaurantContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void loadItems();

        void onRecyclerItemClick(int position);

        void onRecyclerItemLongClick(int position);

    }
}



