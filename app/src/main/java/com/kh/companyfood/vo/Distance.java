package com.kh.companyfood.vo;

/**
 * Created by KIM on 2017-08-09.
 */

public class Distance {
    public int d_id;
    public String name;

    public Distance(int d_id, String name) {
        this.d_id = d_id;
        this.name = name;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
