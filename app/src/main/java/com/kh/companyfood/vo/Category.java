package com.kh.companyfood.vo;

/**
 * Created by KIM on 2017-08-09.
 */

public class Category {
    public int c_id;
    public String name;

    public Category(int c_id, String name) {
        this.c_id = c_id;
        this.name = name;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
