package com.kh.companyfood.vo;

/**
 * Created by KIM on 2017-08-08.
 */

public class RestaurantList {
    public int id;
    public String name;
    public String address;
    public Category category;
    public Weather weather;
    public Distance distance;
    public String description;
    public float ratingAverage;
    public Image restaurantimage_set[];

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Weather getWeather() {
        return weather;
    }

    public Distance getDistance() {
        return distance;
    }

    public String getDescription() {
        return description;
    }

    public float getRatingAverage() {
        return ratingAverage;
    }

    public Image[] getRestaurantimage_set() {
        return restaurantimage_set;
    }
}
