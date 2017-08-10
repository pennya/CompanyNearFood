package com.kh.companyfood.adapter.restaurant;

/**
 * Created by KIM on 2017-06-22.
 */

public class RecyclerViewData {

    public int mId;

    public String mImage;

    public String mTitle;

    public float mStarRating;

    public RecyclerViewData(int mId, String mImage, String mTitle, float mStarRating) {
        this.mId = mId;
        this.mImage = mImage;
        this.mTitle = mTitle;
        this.mStarRating = mStarRating;
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

    public float getmStarRating() {
        return mStarRating;
    }

    public void setmStarRating(float mStarRating) {
        this.mStarRating = mStarRating;
    }
}
