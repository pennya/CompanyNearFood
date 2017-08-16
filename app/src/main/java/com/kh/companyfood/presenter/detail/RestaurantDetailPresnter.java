package com.kh.companyfood.presenter.detail;

import com.kh.companyfood.vo.RestaurantDetail;

/**
 * Created by KIM on 2017-08-08.
 */

public interface RestaurantDetailPresnter {

    void loadDetails(int id);

    interface View {
        void setRestaurantDetail(RestaurantDetail detail);
    }
}
