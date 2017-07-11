package com.kh.companyfood.vo;

/**
 * Created by teruten on 2017-06-26.
 */

public class APIError {

    private int result;
    private String message;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
