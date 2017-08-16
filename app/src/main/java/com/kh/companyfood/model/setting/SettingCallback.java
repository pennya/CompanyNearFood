package com.kh.companyfood.model.setting;

/**
 * Created by KIM on 2017-07-26.
 */

public interface SettingCallback {

    void getVersionResponse(String text);

    void getCurrentLoginIdResponse(String text);

    void getLogoutResponse(String text);

}
