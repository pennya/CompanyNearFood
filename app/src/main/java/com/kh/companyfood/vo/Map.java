package com.kh.companyfood.vo;

/**
 * Created by KIM on 2017-08-16.
 */

public class Map {
    public int id;
    public int restaurant;
    public String latitude;
    public String longitude;
    public float realDistance;

    public int getId() {
        return id;
    }

    public int getRestaurant() {
        return restaurant;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public float getRealDistance() {
        return realDistance;
    }
}
