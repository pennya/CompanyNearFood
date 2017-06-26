package com.kh.companyfood.presenter.main;

import com.kh.companyfood.model.recommnad.RecommandCallback;
import com.kh.companyfood.model.recommnad.RecommandModel;

/**
 * Created by KIM on 2017-06-22.
 */

public class RecommandPresenterImpl implements RecommandContract.Presenter , RecommandCallback{

    private RecommandContract.View mRecommandContractView;

    private RecommandModel mRecommandModel;

    public RecommandPresenterImpl(RecommandContract.View RecommandContractView) {
        mRecommandContractView = RecommandContractView;
        mRecommandModel = new RecommandModel(this);
    }

    @Override
    public void buttonClickAction(int[] category, int[] weather, int[] distance) {
        mRecommandModel.requestRecommandRestaurant(category, weather, distance);
    }

    @Override
    public void getNetworkResponse(String text, int status) {
        mRecommandContractView.ShowToast(text + " " + status);
    }
}
