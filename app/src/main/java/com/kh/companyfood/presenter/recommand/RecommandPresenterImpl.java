package com.kh.companyfood.presenter.recommand;

import com.kh.companyfood.model.recommnad.RecommandCallback;
import com.kh.companyfood.model.recommnad.RecommandModel;

/**
 * Created by KIM on 2017-06-22.
 */

public class RecommandPresenterImpl implements RecommandPresenter , RecommandCallback{

    private RecommandPresenter.View mView;

    private RecommandModel mRecommandModel;

    public RecommandPresenterImpl(RecommandPresenter.View view) {
        mView = view;
        mRecommandModel = new RecommandModel(this);
    }

    @Override
    public void buttonClickAction(int[] category, int[] weather, int[] distance) {
        mRecommandModel.requestRecommandRestaurant(category, weather, distance);
    }

    @Override
    public void getNetworkResponse(String text, int status) {
        mView.ShowToast(text + " " + status);
    }
}
