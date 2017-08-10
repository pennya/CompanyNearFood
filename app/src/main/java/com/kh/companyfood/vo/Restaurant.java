package com.kh.companyfood.vo;

/**
 * Created by KIM on 2017-06-26.
 */

public class Restaurant {
    public int id;
    public String name;
    public String address;
    public Category category;
    public Weather weather;
    public Distance distance;
    public String description;

    public Restaurant(int id, String name, String address, Category category, Weather weather, Distance distance, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.category = category;
        this.weather = weather;
        this.distance = distance;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
