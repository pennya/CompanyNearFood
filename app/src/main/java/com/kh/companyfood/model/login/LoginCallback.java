package com.kh.companyfood.model.login;

import com.kh.companyfood.vo.User;

/**
 * Created by teruten on 2017-06-08.
 */

public interface LoginCallback {
    void getNetworkResponse(User user, int status);
}
