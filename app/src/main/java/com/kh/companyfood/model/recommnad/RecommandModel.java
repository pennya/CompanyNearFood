package com.kh.companyfood.model.recommnad;

import com.kh.companyfood.define.Define;
import com.kh.companyfood.model.Restaurant;
import com.kh.companyfood.network.NetworkManager;
import com.kh.companyfood.network.RecommandService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KIM on 2017-06-26.
 */

public class RecommandModel {

    private RecommandCallback mRecommandCallback;

    public RecommandModel(RecommandCallback recommandCallback) { mRecommandCallback= recommandCallback; }

    public void requestRecommandRestaurant (int[] category, int[] weather, int[] distance) {
        RecommandService recommandService = NetworkManager.getIntance().getRetrofit(RecommandService.class);

        Call<List<Restaurant>> postRecommandCall = recommandService.getRecommands(category, weather, distance);
        postRecommandCall.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                // 응답 성공
                if(response.isSuccessful()) {
                    List<Restaurant> restaurantList = response.body();

                    String restaurant_txt = "";
                    for(Restaurant restaurant : restaurantList){
                        restaurant_txt += restaurant.getName() +
                                restaurant.getAddress() +
                                restaurant.getCategory() +
                                restaurant.getWeather() +
                                restaurant.getDistance() +
                                restaurant.getDescription() +
                                "\n";
                    }

                    mRecommandCallback.getNetworkResponse(restaurant_txt, 200);
                } else {
                    // 응답 실패
                    int StatusCode = response.code();
                    mRecommandCallback.getNetworkResponse("Failed", StatusCode);
                }
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {

            }
        });
    }
}
