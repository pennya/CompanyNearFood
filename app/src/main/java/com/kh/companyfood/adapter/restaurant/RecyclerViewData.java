package com.kh.companyfood.adapter.restaurant;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by KIM on 2017-06-22.
 */

public class RecyclerViewData {

    public String mImage;

    public String mTitle;

    public String mDescription;

    public int mStarRating;

    public int mCommentCount;

    public RecyclerViewData(String mImage, String mTitle, String mDescription, int mStarRating, int mCommentCount) {
        this.mImage = mImage;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mStarRating = mStarRating;
        this.mCommentCount = mCommentCount;
    }
}
