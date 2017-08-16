package com.kh.companyfood.vo;

/**
 * Created by KIM on 2017-08-09.
 */

public class Image {
    public int id;
    public String path;
    public int restarurant;

    public Image(int id, String path, int restarurant) {
        this.id = id;
        this.path = path;
        this.restarurant = restarurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRestarurant() {
        return restarurant;
    }

    public void setRestarurant(int restarurant) {
        this.restarurant = restarurant;
    }
}
