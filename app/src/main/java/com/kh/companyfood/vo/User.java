package com.kh.companyfood.vo;

/**
 * Created by teruten on 2017-06-07.
 */

public class User {
    public String id;
    public String password;
    public String email;

    public User(String id, String password, String email){
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}