package com.kh.companyfood.vo;

/**
 * Created by KIM on 2017-08-16.
 */

public class RestaurantDetail {
    public RestaurantList restaurant[];
    public Star userRating[];
    public int commentCount;
    public Map map[];

    public RestaurantList[] getRestaurant() {
        return restaurant;
    }

    public Star[] getUserRating() {
        return userRating;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public Map[] getMap() {
        return map;
    }
}
