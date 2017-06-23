package com.kh.companyfood.presenter.main;

/**
 * Created by KIM on 2017-06-22.
 */

public class RecommandPresenterImpl implements RecommandContract.Presenter {

    private RecommandContract.View mRecommandContractView;

    public RecommandPresenterImpl(RecommandContract.View RecommandContractView) {
        mRecommandContractView = RecommandContractView;
    }

    @Override
    public void buttonClickAction() {
        mRecommandContractView.ShowToast("Completed");
    }
}
