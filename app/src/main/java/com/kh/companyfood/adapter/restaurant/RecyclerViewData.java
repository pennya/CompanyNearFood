package com.kh.companyfood.adapter.restaurant;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by KIM on 2017-06-22.
 */

public class RecyclerViewData {

    public int mId;

    public String mImage;

    public String mTitle;

    public String mDescription;

    public int mStarRating;

    public int mCommentCount;

    public RecyclerViewData(int mId, String mImage, String mTitle, String mDescription, int mStarRating, int mCommentCount) {
        this.mId = mId;
        this.mImage = mImage;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mStarRating = mStarRating;
        this.mCommentCount = mCommentCount;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getmStarRating() {
        return mStarRating;
    }

    public void setmStarRating(int mStarRating) {
        this.mStarRating = mStarRating;
    }

    public int getmCommentCount() {
        return mCommentCount;
    }

    public void setmCommentCount(int mCommentCount) {
        this.mCommentCount = mCommentCount;
    }
}
