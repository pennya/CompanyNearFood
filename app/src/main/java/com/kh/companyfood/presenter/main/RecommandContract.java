package com.kh.companyfood.presenter.main;

/**
 * Created by KIM on 2017-06-22.
 */

public interface RecommandContract {
    interface View extends BaseView<Presenter> {

    }
    interface Presenter extends BasePresenter {
        void buttonClickAction();
    }
}
