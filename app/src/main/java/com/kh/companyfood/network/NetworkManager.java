package com.kh.companyfood.network;

import com.kh.companyfood.define.Define;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by teruten on 2017-06-07.
 */

public class NetworkManager {
    private static final NetworkManager networkManager = new NetworkManager();

    private NetworkManager() {
    }

    public static NetworkManager getIntance() {
        return networkManager;
    }

    public <T> T getRetrofit(Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Define.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(service);
    }

}
