package com.kh.companyfood.presenter.recommand;

/**
 * Created by KIM on 2017-06-22.
 */

public interface RecommandPresenter {

    void buttonClickAction(int[] category, int[] weather, int[] distance);

    interface View {

        void ShowToast(String msg);

    }

}
