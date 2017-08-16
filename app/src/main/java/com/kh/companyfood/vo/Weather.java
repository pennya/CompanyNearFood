package com.kh.companyfood.vo;

/**
 * Created by KIM on 2017-08-09.
 */

public class Weather {
    public int w_id;
    public String name;

    public Weather(int w_id, String name) {
        this.w_id = w_id;
        this.name = name;
    }

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
