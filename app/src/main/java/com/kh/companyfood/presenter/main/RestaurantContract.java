package com.kh.companyfood.presenter.main;

/**
 * Created by KIM on 2017-06-21.
 */

public interface RestaurantContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void buttonClickAction();
    }
}



