package com.kh.companyfood.model;

/**
 * Created by KIM on 2017-06-26.
 */

public class Restaurant {
    public String name;
    public String address;
    public int category;
    public int weather;
    public int distance;
    public String description;

    public Restaurant(String name, String address, int category, int weather, int distance, String description) {
        this.name = name;
        this.address = address;
        this.category = category;
        this.weather = weather;
        this.distance = distance;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
