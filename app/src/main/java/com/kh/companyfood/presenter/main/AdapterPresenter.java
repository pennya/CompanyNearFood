package com.kh.companyfood.presenter.main;

import com.kh.companyfood.adapter.restaurant.RecyclerViewData;

import java.util.ArrayList;

/**
 * Created by KIM on 2017-06-23.
 */

public interface AdapterPresenter {

    void notifyAdapter();

    void setItems(ArrayList<RecyclerViewData> dataList);

}
